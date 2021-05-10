package shop.cloud.order.configuration;/*package com.awn.cloud.shoporder.configuration;

import com.alibaba.csp.sentinel.adapter.servlet.CommonFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigFilterContext {

    @Bean
    public FilterRegistrationBean sentinelFilterRegistration(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new CommonFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter(CommonFilter.WEB_CONTEXT_UNIFY,"false");
        filterRegistrationBean.setName("sentinelFilter");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }

}*/
