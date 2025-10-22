package com.example.lektion5.message;


import org.springframework.data.repository.reactive.ReactiveCrudRepository;


public interface MessageRepository extends ReactiveCrudRepository<Message, Long> {


}
