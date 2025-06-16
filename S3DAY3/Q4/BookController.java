package com.example.demo.controller;

import com.example.demo.exception.CustomException;
import com.example.demo.model.Book;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {

    private Map<Long, Book> books = new HashMap<>();
    private AtomicLong idGen = new AtomicLong();

    @GetMapping
    public List<Book> getAllBooks(@RequestParam(required = false) String author,
                                  @RequestParam(required = false) Integer year,
                                  @RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int size) {
        return books.values().stream()
                .filter(b -> author == null || b.getAuthor().equalsIgnoreCase(author))
                .filter(b -> year == null || b.getPublishedYear() == year)
                .skip(page * size)
                .limit(size)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return Optional.ofNullable(books.get(id))
                .orElseThrow(() -> new CustomException("Book not found"));
    }

    @PostMapping
    public Book create(@Valid @RequestBody Book book) {
        book.setId(idGen.incrementAndGet());
        books.put(book.getId(), book);
        return book;
    }

    @PutMapping("/{id}")
    public Book update(@PathVariable Long id, @Valid @RequestBody Book book) {
        if (!books.containsKey(id)) throw new CustomException("Book not found");
        book.setId(id);
        books.put(id, book);
        return book;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        if (!books.containsKey(id)) throw new CustomException("Book not found");
        books.remove(id);
    }
}
