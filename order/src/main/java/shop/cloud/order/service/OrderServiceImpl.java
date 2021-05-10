package shop.cloud.order.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson.JSON;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import shop.cloud.common.domain.Order;
import shop.cloud.common.domain.Product;
import shop.cloud.order.dao.OrderDao;
import shop.cloud.order.sentinel.OrderBlockedHandler;
import shop.cloud.order.sentinel.OrderFallBackHandler;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    //v1 采用RestTemplate远程调用
    //@Autowired
    //private RestTemplate rest;

    //v2 采用nacos提供的服务发现客户端调用远程服务
    @Autowired
    private DiscoveryClient discoveryClient;

    //v3 采用feign调动方式 调用本地服务一样调用远程服务
//    @Autowired
//    private FeignProductService feignProductService;

    //dubbo的引用服务注解
    @Reference(check = false)
    private shop.cloud.common.dubbo.ProductService productService;

    //@Autowired
    //private RocketMQTemplate mq;

/*
	@Override
	public Order createOrder(Integer pid) {
		log.info("接收到{}号商品下单请求,调用商品微服务查询信息",pid);
		Product p = rest.getForObject("http://127.0.0.1:8081/product/"+pid,Product.class);
		log.info("查询到{}号商品信息，内容：{}",pid, JSON.toJSONString(p));

		Order o = new Order();
		o.setUid(1);
		o.setUsername("测试用户");
		o.setPid(pid);
		o.setPname(p.getPname());
		o.setPprice(p.getPprice());
		o.setNumber(1);

		log.info("订单创建，内容：{}",JSON.toJSONString(o));

		orderDao.save(o);

		return o;
	}*/


    @Override
    @GlobalTransactional(rollbackFor = Exception.class)
    public Order createOrder(Integer pid) {
		/*自定义随机轮询负载均衡 nacos + ribbon
		List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
		int index = new Random().nextInt(instances.size());
		ServiceInstance serviceInstance = instances.get(index);
		Product p = rest.getForObject("http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/product/"+pid,Product.class);
		log.info("查询到{}号商品信息，负载端口：{}，内容：{}",pid,serviceInstance.getPort(),JSON.toJSONString(p));
		*/

        //nacos + ribbon负载均衡 - 默认沦陷
//        Product p = rest.getForObject("http://service-product/product/" + pid, Product.class);
//		log.info("查询到{}号商品信息，内容：{}",pid,JSON.toJSONString(p));

        //Feign方式
//        Product p = feignProductService.getProductById(pid);
//        Order o = new Order();
//        o.setUid(1);
//        o.setUsername("测试用户:");
//        o.setPid(pid);
//        o.setPname(p.getPname());
//        o.setPprice(p.getPprice());
//        o.setNumber(1);
//        o.setPort(p.getPort());
//        log.info("feign远程调用 ： 订单创建：{},下单商品：{},服务信息：{}", JSON.toJSONString(o), JSON.toJSONString(p), JSON.toJSONString(p.getPort()));


        //dubbo方式
        Product p = productService.findById(pid);
        Order o = new Order();
        o.setUid(1);
        o.setUsername("测试用户:");
        o.setPid(pid);
        o.setPname(p.getPname());
        o.setPprice(p.getPprice());
        o.setNumber(1);
        o.setPort(p.getPort());
        log.info("dubbo远程调用 ： 订单创建：{},下单商品：{},服务信息：{}", JSON.toJSONString(o), JSON.toJSONString(p), JSON.toJSONString(p.getPort()));

        orderDao.save(o);

        //扣库存
//        feignProductService.reduceInventory(pid, 1);

        //通知MQ
        //mq.convertAndSend("order-topic", o);

        return o;
    }

    @Override
    @SentinelResource(value = "message5str", blockHandler = "blockHandler", blockHandlerClass = OrderBlockedHandler.class, fallback = "fallBack", fallbackClass = OrderFallBackHandler.class)
    public String message5Str(String name, String age) {
        int i = 3 - 2 - 1;
        final int i1 = 5 / i;
        System.out.println(i1);
        return "from 5 to 5String";
    }

}
