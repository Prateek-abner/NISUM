package com.example.demo.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
public class EventListener {
    private static final Logger logger = LoggerFactory.getLogger(EventListener.class);

    @KafkaListener(topics = "events", groupId = "event-group", errorHandler = "dlqErrorHandler")
    public void handleEvent(String event, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        if (event.contains("error")) {
            throw new RuntimeException("Invalid event data: " + event);
        }
        logger.info("Processed event from {}: {}", topic, event);
    }
}
