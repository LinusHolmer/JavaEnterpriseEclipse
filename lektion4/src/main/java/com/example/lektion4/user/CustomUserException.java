package com.example.lektion4.user;

public class CustomUserException extends RuntimeException{


    public CustomUserException(String message){
        super(
                """
                Something happened to the CustomUser: %s
                """.formatted(message)
        );
    }
}
