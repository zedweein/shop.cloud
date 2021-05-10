package shop.cloud.order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import shop.cloud.common.domain.Product;

//feign指定sentinel容错支持
//@FeignClient(value = "service-product",fallback = FeignProductServiceFallBack.class)//指定微服务名称
@FeignClient(value = "service-product",fallbackFactory = FeignProductServiceFallBackFactory.class)//指定微服务名称
public interface FeignProductService {

    @RequestMapping("/product/{pid}")
    Product getProductById(@PathVariable Integer pid);

    @RequestMapping("/product/reduce")
    void reduceInventory(@RequestParam("pid") Integer pid, @RequestParam("num") Integer num);
}
