package com.example.demo;

public class Order {
    private String id;
    private double amount;

    public Order(String id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }
}