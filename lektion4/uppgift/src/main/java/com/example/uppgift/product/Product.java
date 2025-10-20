package com.example.uppgift.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

// fatta inte hur man skulle använda bara 1 dependency, så jag använder alla 3

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank @Size(min = 2, message = "Name must be at least 2 chars")
    String name;

    @DecimalMin(value = "0.01", inclusive = true, message = "Price must be at least 0.01")
    BigDecimal price;

    public Product() {}

    public Product(BigDecimal price, String name) {
        this.price = price;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
