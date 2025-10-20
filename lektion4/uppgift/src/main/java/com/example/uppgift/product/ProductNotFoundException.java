package com.example.uppgift.product;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String name) {
        super(
                """
                User with username %s not found
                """.formatted(name)
        );
    }
}
