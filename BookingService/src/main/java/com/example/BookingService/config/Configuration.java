package com.example.BookingService.config;

import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    public String generate(){
        return "bean created";
    }
}
