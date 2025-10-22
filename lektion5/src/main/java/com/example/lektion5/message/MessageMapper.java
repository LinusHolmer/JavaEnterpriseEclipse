package com.example.lektion5.message;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MessageMapper {
    public CreateMessageDTO toCreateDTO(Message message) {
        return new CreateMessageDTO(
                message.message()
        );
    }

    public Message toEntity(CreateMessageDTO createMessageDTO) {
        return new Message(
                null,
                createMessageDTO.message(),
                LocalDateTime.now(),
                true
        );
    }

    public MessageResponseDTO toResponseDTO(Message message) {
        return new MessageResponseDTO(message.id(),
                message.message(),
                message.createdAt()
        );
    }



}
