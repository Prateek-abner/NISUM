package com.example.demo.controller;

import com.example.demo.entity.BookEntity;
import com.example.demo.exception.BookNotFoundException;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService; // Dependency Injection
    }

   
    @GetMapping
    public ResponseEntity<List<BookEntity>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

  
    @GetMapping("/{id}")
    public ResponseEntity<BookEntity> getBookById(@PathVariable Long id) {
        return bookService.getBookById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    
    @PostMapping
    public ResponseEntity<BookEntity> createBook(@RequestBody BookEntity book) {
        return ResponseEntity.ok(bookService.createBook(book));
    }
}
