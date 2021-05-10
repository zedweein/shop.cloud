package shop.cloud.order.configuration;//package com.awn.cloud.shoporder.configuration;
//
//import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlBlockHandler;
//import com.alibaba.csp.sentinel.slots.block.BlockException;
//import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
//import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
//import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
//import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
//import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
//import com.alibaba.fastjson.JSON;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Slf4j
//@Component
//public class FlowLimitExceptionHandler implements UrlBlockHandler {
//    @Override
//    public void blocked(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws IOException {
//
//
//        String result = e.getMessage();
//        if(e instanceof FlowException){
//            result = "接口限流";
//        }
//        if(e instanceof DegradeException){
//            result = "降级异常";
//        }
//        if(e instanceof ParamFlowException){
//            result = "参数限流";
//        }
//        if(e instanceof AuthorityException){
//            result = "授权异常";
//        }
//        if(e instanceof SystemBlockException){
//            result = "系统负载异常";
//        }
//        httpServletResponse.setContentType("application/json;charset=utf-8");
//        httpServletResponse.getWriter().write(JSON.toJSONString(result));
//    }
//
//}
