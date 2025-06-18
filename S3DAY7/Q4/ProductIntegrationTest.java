package com.example.demo;

import com.example.demo.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    static Long savedProductId;

    Product testProduct = new Product(
            "Laptop", "High-end gaming laptop", 1499.99, 10, "Electronics");

    @Test
    @Order(1)
    void testAddProduct() throws Exception {
        String json = objectMapper.writeValueAsString(testProduct);

        mockMvc.perform(post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Laptop"))
                .andDo(result -> {
                    Product created = objectMapper.readValue(result.getResponse().getContentAsString(), Product.class);
                    savedProductId = created.getId();
                });
    }

    @Test
    @Order(2)
    void testGetAllProducts() throws Exception {
        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").exists());
    }

    @Test
    @Order(3)
    void testGetProductById() throws Exception {
        mockMvc.perform(get("/products/{id}", savedProductId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Laptop"));
    }

    @Test
    @Order(4)
    void testUpdateProduct() throws Exception {
        testProduct.setName("Updated Laptop");
        String updatedJson = objectMapper.writeValueAsString(testProduct);

        mockMvc.perform(put("/products/{id}", savedProductId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Updated Laptop"));
    }

    @Test
    @Order(5)
    void testDeleteProduct() throws Exception {
        mockMvc.perform(delete("/products/{id}", savedProductId))
                .andExpect(status().isNoContent());
    }

    @Test
    @Order(6)
    void testProductNotFoundAfterDelete() throws Exception {
        mockMvc.perform(get("/products/{id}", savedProductId))
                .andExpect(status().isNotFound());
    }
}
