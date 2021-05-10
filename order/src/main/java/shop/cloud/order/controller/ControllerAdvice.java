package shop.cloud.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@org.springframework.web.bind.annotation.ControllerAdvice
@Slf4j
public class ControllerAdvice {
	//@ExceptionHandler(value =Exception.class)
	public void exceptionHandler(Exception e){
		log.error("异常统一捕获："+e.getMessage());
    }
}
