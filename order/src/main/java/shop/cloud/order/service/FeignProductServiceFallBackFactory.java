package shop.cloud.order.service;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import shop.cloud.common.domain.Product;

//容错类，方式一，一旦feign远程出现问题，就会执行该逻辑，但缺点是无法获取异常信息 不利于排查问题，因此一般用factory来实现，可以获取异常
@Component
@Slf4j
public class FeignProductServiceFallBackFactory implements FallbackFactory<FeignProductService> {

    @Override
    public FeignProductService create(Throwable throwable) {
           return new FeignProductService() {
               @Override
               public Product getProductById(Integer pid) {
                   log.error("{}",throwable);
                   //容错逻辑
                   Product p = new Product();
                   p.setPid(-1);
                   p.setPname("容错商品");
                   return p;
               }

               @Override
               public void reduceInventory(Integer pid, Integer num) {

               }
           };
    }
}
