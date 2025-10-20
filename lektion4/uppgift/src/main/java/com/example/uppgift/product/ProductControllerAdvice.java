package com.example.uppgift.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class ProductControllerAdvice {

    private static final Logger log = LoggerFactory.getLogger(ProductControllerAdvice.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<HashMap<String, String>> handleValidationErrors(
            MethodArgumentNotValidException exception
    ) {
        HashMap<String, String> errors = new HashMap<>();

        exception
                .getBindingResult()
                .getFieldErrors()
                .forEach(fieldError -> { errors.put(
                        fieldError.getField(),
                        fieldError.getDefaultMessage());
                    log.warn("Validation failed for field '{}': {}", fieldError.getField(), fieldError.getDefaultMessage());
                });
        return ResponseEntity.badRequest().body(errors);

    }
}
