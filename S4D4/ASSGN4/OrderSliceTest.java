package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJdbcTest
class OrderSliceTest {

    @Autowired
    private OrderRepository orderRepository;

    @MockBean
    private PaymentGatewayClient paymentGatewayClient;

    @Test
    void testOrderRepository() {
        Order order = new Order("1", 100.0);
        orderRepository.save(order);
        assertNotNull(orderRepository.findById("1"));
    }
}