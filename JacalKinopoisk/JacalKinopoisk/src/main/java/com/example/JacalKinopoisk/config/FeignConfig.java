package com.example.JacalKinopoisk.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {
    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> requestTemplate.header("X-API-KEY", "35C79BJ-N1DMZX3-JDKR6EP-0WWT4AQ");
    }
}
