package com.example.lektion5.message;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/lektion5")
public class MessageController {

    private final MessageService messageService;
    private final MessageMapper messageMapper;

    @Autowired
    public MessageController(MessageService messageService, MessageMapper messageMapper) {
        this.messageService = messageService;
        this.messageMapper = messageMapper;
    }

    @PostMapping("/create")
    public Mono<ResponseEntity<MessageResponseDTO>> createMessage(@Valid @RequestBody CreateMessageDTO createMessageDTO) {
        return messageService.createMessageService(createMessageDTO)
                .map(savedMessage -> ResponseEntity.status(HttpStatus.CREATED).body(messageMapper.toResponseDTO(
                        savedMessage
                        ))
                );
    }


}
