package com.example.demo.duck;

import reactor.core.publisher.Mono;

public interface DuckService {

    Mono<byte[]> getDuck(String imageFile);
}
