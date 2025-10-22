package com.example.lektion5.message;


import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface MessageRepository extends ReactiveCrudRepository<Message, Long> {


}
