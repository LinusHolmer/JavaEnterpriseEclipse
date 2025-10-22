package com.example.lektion5.message;

public class MessageNotFoundException extends RuntimeException {
    public MessageNotFoundException(String message) {
        super(
                """
                Message with content %s. Please try again.
                """.formatted(message)
        );
    }
}
