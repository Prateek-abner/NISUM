package com.example.demo;

public interface PaymentGatewayClient {
    void processPayment(String orderId, double amount);
}