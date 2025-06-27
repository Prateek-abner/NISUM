package com.example.demo;

public class PriceFacade {
    private final PriceCalculator calculator;

    public PriceFacade(PriceCalculator calculator) {
        this.calculator = calculator;
    }

    public double getPrice(double basePrice) {
        try {
            return calculator.computePrice(basePrice);
        } catch (ArithmeticException e) {
            return 100.0; // Default value
        }
    }
}