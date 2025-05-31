package com.capston_design.fkiller.itoms.ticket_core.config;

import org.springframework.cloud.openfeign.clientconfig.FeignClientConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    @Bean
    public FeignClientConfigurer feignClientConfigurer() {
        return new FeignClientConfigurer() {};
    }
}