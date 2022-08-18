package com.elena.mystore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration {

    @Bean
    public ApplicationProperties applicationProperties(ApplicationProperties applicationProperties) {
        return applicationProperties;
    }
}
