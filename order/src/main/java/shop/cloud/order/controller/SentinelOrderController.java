package shop.cloud.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.cloud.order.service.OrderService;

@Slf4j
@RestController
public class SentinelOrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/order/message1")
    public String message1(){
        return "message1";
    }

    @RequestMapping("/order/message2")
    public String message2(){
        return "message2";
    }


    int i = 0;
    @RequestMapping("/order/message3")
    public String message3(){
        i++;
        if(i%3 == 0){
            throw new RuntimeException();
        }
        return "message3";
    }


    @RequestMapping("/order/message4")
    public String message4(String name,String age){
        return "message4 : " + name + " , " + age;
    }

    @RequestMapping("/order/message5")
    public String message5(String name, String age) {
        return orderService.message5Str(name,age);
    }
}
