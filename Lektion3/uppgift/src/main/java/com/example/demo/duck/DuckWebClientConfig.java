package com.example.demo.duck;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration

public class DuckWebClientConfig {

    @Bean
    public WebClient webClientDuckBuilder (WebClient.Builder builder) {
        return builder
                .baseUrl("https://random-d.uk/api/v2/")
                .build();
    }
}
