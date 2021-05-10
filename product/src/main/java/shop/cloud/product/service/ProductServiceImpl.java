package shop.cloud.product.service;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shop.cloud.common.domain.Product;
import shop.cloud.product.dao.ProductDao;

//spring注解
//@Service
//dubbo注解用于暴露服务，用于dubbo远程协议
@Component
@Service
@Slf4j
public class ProductServiceImpl implements shop.cloud.common.dubbo.ProductService {
	
	@Autowired
	private ProductDao productDao;

	@Override
	public Product findById(Integer pid) {
		return productDao.findById(pid).get();
	}

	@Override
	public void reduceInventory(Integer pid, Integer num) {
		Product product = productDao.findById(pid).get();
		if(product.getStock() <= 0){
			//库存校验
			log.error("扣减库存失败,库存不足 => " + JSON.toJSONString(product));
			return;
		}
		product.setStock(product.getStock() - num);
		
		//模拟一个异常 引入 seata
		int i = 1 / 0;

		productDao.save(product);
	}

}
