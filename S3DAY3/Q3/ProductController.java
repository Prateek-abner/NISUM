@PostMapping
public Product addProduct(@Valid @RequestBody Product product) {
    product.setId(idCounter.incrementAndGet());
    products.add(product);
    return product;
}

@PutMapping("/{id}")
public ResponseEntity<Product> updateProduct(@PathVariable Long id, @Valid @RequestBody Product updatedProduct) {
    for (Product p : products) {
        if (p.getId().equals(id)) {
            p.setName(updatedProduct.getName());
            p.setPrice(updatedProduct.getPrice());
            return ResponseEntity.ok(p);
        }
    }
    return ResponseEntity.notFound().build();
}
