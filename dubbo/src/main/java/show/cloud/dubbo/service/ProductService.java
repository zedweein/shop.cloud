package shop.cloud.common.dubbo;

import shop.cloud.common.domain.Product;

/**
 * 企业开发中一般会单独开启一个接口工程来做这件事
 */
public interface ProductService {

    Product findById(Integer pid);

    void reduceInventory(Integer pid, Integer num);
}
