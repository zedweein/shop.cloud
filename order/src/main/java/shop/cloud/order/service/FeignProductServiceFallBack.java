package shop.cloud.order.service;

import org.springframework.stereotype.Component;
import shop.cloud.common.domain.Product;

//容错类，方式一，一旦feign远程出现问题，就会执行该逻辑，但缺点是无法获取异常信息 不利于排查问题
@Component
public class FeignProductServiceFallBack implements FeignProductService{
    @Override
    public Product getProductById(Integer pid) {
        //容错逻辑
        Product p = new Product();
        p.setPid(-1);
        p.setPname("容错商品");
        return p;
    }

    @Override
    public void reduceInventory(Integer pid, Integer num) {

    }
}
