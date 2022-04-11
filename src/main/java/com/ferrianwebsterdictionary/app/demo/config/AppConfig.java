package com.ferrianwebsterdictionary.app.demo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {



    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }


}
