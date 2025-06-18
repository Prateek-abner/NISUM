package com.example.library;

import com.example.library.model.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookIntegrationTest {

    @Autowired private MockMvc mockMvc;
    @Autowired private ObjectMapper objectMapper;

    static Long bookId;

    Book testBook = new Book("1984", "George Orwell", 1949);

    @Test
    @Order(1)
    void testCreateBook() throws Exception {
        String json = objectMapper.writeValueAsString(testBook);

        mockMvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("1984"))
                .andDo(result -> {
                    Book created = objectMapper.readValue(result.getResponse().getContentAsString(), Book.class);
                    bookId = created.getId();
                });
    }

    @Test
    @Order(2)
    void testGetAllBooks() throws Exception {
        mockMvc.perform(get("/books"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(greaterThan(0))));
    }

    @Test
    @Order(3)
    void testGetBookById() throws Exception {
        mockMvc.perform(get("/books/{id}", bookId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.author").value("George Orwell"));
    }

    @Test
    @Order(4)
    void testUpdateBook() throws Exception {
        testBook.setTitle("Animal Farm");
        String json = objectMapper.writeValueAsString(testBook);

        mockMvc.perform(put("/books/{id}", bookId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Animal Farm"));
    }

    @Test
    @Order(5)
    void testDeleteBook() throws Exception {
        mockMvc.perform(delete("/books/{id}", bookId))
                .andExpect(status().isNoContent());
    }

    @Test
    @Order(6)
    void testGetBookNotFound() throws Exception {
        mockMvc.perform(get("/books/{id}", bookId))
                .andExpect(status().isNotFound());
    }
}
