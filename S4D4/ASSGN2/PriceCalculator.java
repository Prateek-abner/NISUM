package com.example.demo;

public class PriceCalculator {
    private double calculateTax(double basePrice) {
        // Heavy legacy method
        return basePrice * 0.1;
    }

    public double computePrice(double basePrice) {
        return basePrice + calculateTax(basePrice);
    }
}