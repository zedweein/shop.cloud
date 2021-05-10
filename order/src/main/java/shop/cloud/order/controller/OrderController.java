package shop.cloud.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.cloud.common.domain.Order;
import shop.cloud.order.service.OrderService;

@RestController
@Slf4j
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/order/prod/{pid}")
	public Order order(@PathVariable("pid")Integer pid){
		return orderService.createOrder(pid);
	}
}
