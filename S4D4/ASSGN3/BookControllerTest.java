package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = BookController.class)
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    void testGetBookValidId() throws Exception {
        Book book = new Book("1", "Test Book");
        when(bookService.findById("1")).thenReturn(book);

        mockMvc.perform(get("/api/books/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.title").value("Test Book"));
    }

    @Test
    void testGetBookInvalidId() throws Exception {
        when(bookService.findById("2")).thenThrow(new BookNotFoundException("2"));

        mockMvc.perform(get("/api/books/2"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Book not found: 2"));
    }
}