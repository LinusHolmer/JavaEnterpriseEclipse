package com.example.lektion5.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class MessageService {

    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;
    private static final Logger log = LoggerFactory.getLogger(MessageService.class);

    @Autowired
    public MessageService(MessageRepository messageRepository, MessageMapper messageMapper) {
        this.messageRepository = messageRepository;
        this.messageMapper = messageMapper;
    }

    public Mono<Message> createMessageService(CreateMessageDTO createMessageDTO) {
        log.info("Creating message with content: {}", createMessageDTO.message());

        return messageRepository.save(messageMapper.toEntity(createMessageDTO))
                // doOnNext är väldigt coolt
                .doOnNext(saved ->
                        log.info("Message created with id: {}, content = {}, createdAt = {}, pinned = {}",
                                saved.id(),
                                saved.message(),
                                saved.createdAt(),
                                saved.pinned()));


    }

}
