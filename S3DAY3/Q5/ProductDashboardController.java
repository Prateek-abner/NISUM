package com.example.demo.controller;

import com.example.demo.exception.CustomException;
import com.example.demo.model.ProductDashboard;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductDashboardController {

    private Map<Long, ProductDashboard> store = new HashMap<>();
    private AtomicLong idGen = new AtomicLong();

    @GetMapping
    public List<ProductDashboard> getProducts(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id,asc") String sort) {

        Comparator<ProductDashboard> comparator = Comparator.comparing(ProductDashboard::getId);
        if (sort.startsWith("price")) {
            comparator = Comparator.comparing(ProductDashboard::getPrice);
        }
        if (sort.endsWith("desc")) {
            comparator = comparator.reversed();
        }

        return store.values().stream()
                .filter(p -> category == null || p.getCategory().equalsIgnoreCase(category))
                .filter(p -> minPrice == null || p.getPrice() >= minPrice)
                .filter(p -> maxPrice == null || p.getPrice() <= maxPrice)
                .sorted(comparator)
                .skip(page * size)
                .limit(size)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ProductDashboard getProduct(@PathVariable Long id) {
        return Optional.ofNullable(store.get(id))
                .orElseThrow(() -> new CustomException("Product not found"));
    }

    @PostMapping
    public ProductDashboard addProduct(@Valid @RequestBody ProductDashboard product) {
        product.setId(idGen.incrementAndGet());
        store.put(product.getId(), product);
        return product;
    }

    @PutMapping("/{id}")
    public ProductDashboard updateProduct(@PathVariable Long id, @Valid @RequestBody ProductDashboard product) {
        if (!store.containsKey(id)) throw new CustomException("Product not found");
        product.setId(id);
        store.put(id, product);
        return product;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        if (!store.containsKey(id)) throw new CustomException("Product not found");
        store.remove(id);
    }
}
