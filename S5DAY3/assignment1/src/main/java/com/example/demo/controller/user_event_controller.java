package com.example.demo.controller;

import com.example.demo.service.UserEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/events")
public class UserEventController {
    private final UserEventService userEventService;

    @Autowired
    public UserEventController(UserEventService userEventService) {
        this.userEventService = userEventService;
    }

    @PostMapping
    public ResponseEntity<String> sendUserEvent(@RequestBody String event) {
        userEventService.sendEvent(event);
        return ResponseEntity.ok("Event sent to Kafka");
    }
}
