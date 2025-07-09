package com.example.demo.service;

import com.example.demo.entity.BookEntity;
import com.example.demo.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

   
    @Transactional(readOnly = true)
    public List<BookEntity> getAllBooks() {
        return bookRepository.findAll();
    }

    
    @Transactional(readOnly = true)
    public Optional<BookEntity> getBookById(Long id) {
        return bookRepository.findById(id);
    }

   
    @Transactional
    public BookEntity createBook(BookEntity book) {
        if (book.getId() != null) {
            throw new IllegalArgumentException("ID should not be set for new book");
        }
        return bookRepository.save(book);
    }
}
