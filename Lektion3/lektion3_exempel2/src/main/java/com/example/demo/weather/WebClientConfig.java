package com.example.demo.weather;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient webClientWeatherBuilder(WebClient.Builder builder) {
        return builder
                .baseUrl("https://api.open-meteo.com/v1/")
                .build();
    }
}
