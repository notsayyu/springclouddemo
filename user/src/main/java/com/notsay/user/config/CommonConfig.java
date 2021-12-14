package com.notsay.user.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @author: dsy
 * @date: 2021/12/5 12:20
 */
@Configuration
public class CommonConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /**
     * 负载均衡算法
     * @return
     */
    @Bean
    public IRule ribbonRule(){
        return new RandomRule();
    }
}