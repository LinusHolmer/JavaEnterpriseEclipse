package com.example.lektion5.message;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record CreateMessageDTO(
      @NotBlank(message = "Message can NOT be blank")
      @Size(min = 3, max = 255, message = "Message must be between 3 and 255 characters")
      String message

) {}
