package com.example.uppgift.product;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record ProductDTO (
        Long id,
        @NotBlank @Size(min = 2, message = "Name must be at least 2 chars")
        String name,
        @DecimalMin(value = "0.01", inclusive = true, message = "Price must be at least 0.01")
        BigDecimal price) {

}
