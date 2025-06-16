package com.example.demo.model;

import jakarta.validation.constraints.*;

public class Book {
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String author;

    @Min(1500)
    private int publishedYear;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public int getPublishedYear() { return publishedYear; }
    public void setPublishedYear(int publishedYear) { this.publishedYear = publishedYear; }
}
