package shop.cloud.order.sentinel;

public class OrderFallBackHandler {

    public static String fallBack(String name, String age, Throwable t){
        return "兜底方法 fallBack : " + t.getMessage();
    }

}
