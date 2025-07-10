package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserEventService {
    private static final Logger logger = LoggerFactory.getLogger(UserEventService.class);
    private final KafkaTemplate<String, String> kafkaTemplate;

    public UserEventService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendEvent(String event) {
        kafkaTemplate.send("user-events", event);
        logger.info("Sent event to Kafka: {}", event);
    }
}
