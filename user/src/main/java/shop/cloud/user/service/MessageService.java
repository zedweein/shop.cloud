package shop.cloud.user.service;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;
import shop.cloud.common.domain.Order;

@Slf4j
@Service
@RocketMQMessageListener(consumerGroup = "shop-user",topic = "order-topic")
public class MessageService implements RocketMQListener<Order> {
    @Override
    public void onMessage(Order order) {
        log.info("收到消息 ： " + JSON.toJSONString(order));
    }
}
