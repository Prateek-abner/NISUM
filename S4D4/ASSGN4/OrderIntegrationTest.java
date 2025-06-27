package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private PaymentGatewayClient paymentGatewayClient;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderService orderService;

    @Test
    void testCreateOrder() {
        Order order = new Order("1", 100.0);
        ResponseEntity<Order> response = restTemplate.postForEntity("/orders", order, Order.class);

        assertEquals(200, response.getStatusCode().value());
        assertEquals("1", response.getBody().getId());
        verify(paymentGatewayClient, times(1)).processPayment("1", 100.0);
    }
}