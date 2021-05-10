//import com.alibaba.fastjson.JSON;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.rocketmq.client.producer.SendCallback;
//import org.apache.rocketmq.client.producer.SendResult;
//import org.apache.rocketmq.spring.core.RocketMQTemplate;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import shop.cloud.order.OrderApplication;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = OrderApplication.class)
//@Slf4j
//public class MessageTypeTest {
//    @Autowired
//    private RocketMQTemplate mq;
//
//    //测试可靠同步消息
//    @Test
//    public void testSynMessage(){
//        SendResult result = mq.syncSend("test-topic-1:test-tag-1", "这是个同步消息！", 1000);
//        log.info(JSON.toJSONString(result));
//    }
//    //测试可靠异步消息
//    @Test
//    public void testAsSynMessage() throws InterruptedException {
//        mq.asyncSend("test-topic-1:test-tag-1", "这是个异步带回调消息！", new SendCallback() {
//            @Override
//            public void onSuccess(SendResult result) {
//                log.info(JSON.toJSONString(result));
//            }
//
//            @Override
//            public void onException(Throwable throwable) {
//                log.info(JSON.toJSONString(throwable));
//            }
//        });
//        Thread.sleep(3000);
//    }
//
//    //测试单向消息
//    @Test
//    public void testOneWay(){
//        mq.sendOneWay("test-topic-1:test-tag-1","这是一个单向消息，无返回！无回调");
//    }
//
//
//
//
//
//}
