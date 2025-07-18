package com.example.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TestControllerCoverage {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testTestEndpoint() throws Exception {
        mockMvc.perform(get("/test"))
                .andExpect(status().isOk())
                .andExpect(content().string("Test Endpoint"));
    }

    @Test
    void testNonExistentEndpoint() throws Exception {
        mockMvc.perform(get("/non-existent"))
                .andExpect(status().isNotFound());
    }
}
