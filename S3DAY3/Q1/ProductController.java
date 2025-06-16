package com.example.demo.controller;

import com.example.demo.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/products")
public class ProductController {

    private List<Product> products = new ArrayList<>();
    private AtomicLong idCounter = new AtomicLong();

    @GetMapping
    public List<Product> getAll() {
        return products;
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        product.setId(idCounter.incrementAndGet());
        products.add(product);
        return product;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        for (Product p : products) {
            if (p.getId().equals(id)) {
                p.setName(updatedProduct.getName());
                p.setPrice(updatedProduct.getPrice());
                return ResponseEntity.ok(p);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        if (products.removeIf(p -> p.getId().equals(id))) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
