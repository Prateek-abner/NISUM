package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final PaymentGatewayClient paymentGatewayClient;

    public OrderService(OrderRepository orderRepository, PaymentGatewayClient paymentGatewayClient) {
        this.orderRepository = orderRepository;
        this.paymentGatewayClient = paymentGatewayClient;
    }

    public Order createOrder(String id, double amount) {
        Order order = new Order(id, amount);
        orderRepository.save(order);
        paymentGatewayClient.processPayment(id, amount);
        return order;
    }
}