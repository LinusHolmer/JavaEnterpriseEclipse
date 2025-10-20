package com.example.lektion4.advice;

/* Handles all exceptions globally, based on what's annotated
 * Catches nothing by default, has to be implemented by annotations
 * Must be annotated with @ControllerAdvice / @RestControllerAdvice
 * Must have @ExceptionHandling annotation
 * Must have matching Exception type, both in params of method and @ExceptionHandler annotations
 * RestControllerAdvice work with ResponseBody (ResponseEntity)
 */


import com.example.lektion4.user.CustomUserException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidationAdvice {

    // mono is not included
    @ExceptionHandler(CustomUserException.class)
    public ResponseEntity<String> test(CustomUserException exception) {

        System.out.println("Our Custom Advice, is running 'test' method!");

        return ResponseEntity.badRequest().body(
                exception.getMessage()
        );

    }

}
