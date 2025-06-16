package com.example.demo.model;

import jakarta.validation.constraints.*;

public class Product {
    private Long id;

    @NotNull(message = "Name cannot be null")
    @Size(min = 3, message = "Name should have at least 3 characters")
    private String name;

    @Min(value = 1, message = "Price must be positive")
    private double price;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}
