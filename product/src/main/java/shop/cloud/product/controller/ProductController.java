package shop.cloud.product.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.cloud.common.domain.Product;
import shop.cloud.product.configuration.WebServerConfig;

@RestController
@Slf4j
@RefreshScope
public class ProductController {

	@Autowired
	private shop.cloud.common.dubbo.ProductService productService;

	@Autowired
	private WebServerConfig config;

	//获取nacos config中心的配置信息上下文
	@Autowired
	private ConfigurableApplicationContext properties;

	//基于注解获取nacos，不支持动态修改nacos配置中心的配置，需要加上@RefreshScope注解来支持动态刷新
	@Value(value = "${test.config.env}")
	private String serverAdd;
	
	@RequestMapping("/product/{pid}")
	public Product get(@PathVariable("pid")Integer pid){
		Product p = productService.findById(pid);
		p.setPort(config.getServer().getPort());
		log.info("from context : " + properties.getEnvironment().getProperty("test.config.env"));
		log.info("from annotation with @RefreshScope： " + serverAdd);
		return p;
	}

	//扣减库存
	@RequestMapping("/product/reduce")
	public void reduceInventory(Integer pid,Integer num){
		productService.reduceInventory(pid,num);
	}


	@RequestMapping("/product/api1/demo1")
	public String demo1(){
		return "api1-demo1";
	}

	@RequestMapping("/product/api1/demo2")
	public String demo2(){
		return "api1-demo2";
	}

	@RequestMapping("/product/api2/demo1")
	public String demo3(){
		return "api2-demo1";
	}
	@RequestMapping("/product/api2/demo2")
	public String demo4(){
		return "api2-demo2";
	}

}
