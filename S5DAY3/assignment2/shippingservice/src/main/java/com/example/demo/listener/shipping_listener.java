package com.example.demo.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ShippingListener {
    private static final Logger logger = LoggerFactory.getLogger(ShippingListener.class);

    @KafkaListener(topics = "order.created", groupId = "shipping-group")
    public void handleOrder(String order) {
        logger.info("Received order for shipping: {}. Reserving stock...", order);
        logger.info("Shipping confirmed for order: {}", order);
    }
}
