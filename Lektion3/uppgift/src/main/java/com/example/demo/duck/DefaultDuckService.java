package com.example.demo.duck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class DefaultDuckService implements DuckService {

    private final WebClient webClient;

    @Autowired
    public DefaultDuckService(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Mono<byte[]> getDuck(String imageFile) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .pathSegment(imageFile)
                        .build()
                )
                .retrieve()
                .onStatus(
                        httpStatusCode -> httpStatusCode.is4xxClientError(),
                        clientResponse -> Mono.error(new RuntimeException("Not Found"))
                )
                .onStatus(
                        httpStatusCode -> httpStatusCode.is4xxClientError(),
                        clientResponse -> Mono.error(new RuntimeException("Not Found"))
                )
                .bodyToMono(byte[].class);
    }
}
