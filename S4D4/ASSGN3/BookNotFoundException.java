package com.example.demo;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String id) {
        super("Book not found: " + id);
    }
}