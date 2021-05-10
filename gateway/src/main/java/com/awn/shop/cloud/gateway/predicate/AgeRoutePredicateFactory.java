package com.awn.shop.cloud.gateway.predicate;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 自定义路由断言
 * 要求名称是propertis中配置的名字 Age + PredicateFactory
 */
@Component
public class AgeRoutePredicateFactory extends AbstractRoutePredicateFactory<AgeRoutePredicateFactory.Config> {
    

    public AgeRoutePredicateFactory() {
        super(AgeRoutePredicateFactory.Config.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(AgeRoutePredicateFactory.Config config) {
        return new Predicate<ServerWebExchange>() {
            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
               //接收前台传入的age参数
                Integer age = Integer.valueOf(serverWebExchange.getRequest().getQueryParams().getFirst("age"));
                return age != null && age <= config.getMaxAge() && age >= config.getMinAge();
            }
        };
    }

    @Override
    public List<String> shortcutFieldOrder() {
        //和配置文件中的顺序要一直
        return Arrays.asList("minAge","maxAge");
    }

    @Data
    @NoArgsConstructor//无参构造
    public static class Config {
        private Integer minAge;
        private Integer maxAge;
    }
}
