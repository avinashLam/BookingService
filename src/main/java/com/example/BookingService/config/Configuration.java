package com.example.BookingService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    public String generate(){
        return "bean created";
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
