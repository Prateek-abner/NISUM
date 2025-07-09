package com.example.demo.service;

import org.springframework.stereotype.Service;


@Service
public class HelloService {
    
    public String getGreeting(String name) {
        return "Hello, " + name + "! Today is " + java.time.LocalDate.now() + " at " + java.time.LocalTime.now();
    }
}
