package shop.cloud.order.service;


import shop.cloud.common.domain.Order;

public interface OrderService {
	Order createOrder(Integer o);

    String message5Str(String name, String age);
}
