package shop.cloud.order.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@Configuration
public class ConfigRestTemplate {
    @Bean
    @LoadBalanced//采用ribbon实现负载均衡策略
    public org.springframework.web.client.RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
