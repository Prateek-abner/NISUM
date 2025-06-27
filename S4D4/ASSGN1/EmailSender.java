package com.example.demo;

public interface EmailSender {
    void send(String email, String subject, String body);
}