package shop.cloud.order.sentinel;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class OrderBlockedHandler {

    public static String blockHandler(String name, String age, BlockException e){
        return "兜底方法 blockHandler : " + e.getMessage();
    }

}
