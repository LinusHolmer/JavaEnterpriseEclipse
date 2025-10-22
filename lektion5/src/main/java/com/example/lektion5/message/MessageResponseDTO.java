package com.example.lektion5.message;

import java.time.LocalDateTime;

public record MessageResponseDTO (
        Long id,
        String message,
        LocalDateTime createdAt
){}
