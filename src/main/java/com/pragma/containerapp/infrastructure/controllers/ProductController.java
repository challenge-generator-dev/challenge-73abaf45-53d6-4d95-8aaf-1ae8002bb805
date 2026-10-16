package com.pragma.containerapp.infrastructure.controllers;

import com.pragma.containerapp.application.service.ProductService;
import com.pragma.containerapp.domain.model.Product;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@Valid @RequestBody CreateProductRequest request) {
        Product product = productService.createProduct(
            request.name(),
            request.description(),
            request.price(),
            request.category(),
            request.stockQuantity()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable UUID id) {
        return productService.getProductById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable String category) {
        List<Product> products = productService.getProductsByCategory(category);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProductsByName(@RequestParam String name) {
        List<Product> products = productService.searchProductsByName(name);
        return ResponseEntity.ok(products);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable UUID id,
            @Valid @RequestBody UpdateProductRequest request) {
        Product product = productService.updateProduct(
            id,
            request.name(),
            request.description(),
            request.price(),
            request.category(),
            request.stockQuantity()
        );
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteProduct(@PathVariable UUID id) {
        boolean deleted = productService.deleteProduct(id);
        return ResponseEntity.ok(Map.of("deleted", deleted));
    }

    @PostMapping("/{id}/stock/increase")
    public ResponseEntity<Product> increaseStock(
            @PathVariable UUID id,
            @Valid @RequestBody StockChangeRequest request) {
        Product product = productService.increaseStock(id, request.quantity());
        return ResponseEntity.ok(product);
    }

    @PostMapping("/{id}/stock/decrease")
    public ResponseEntity<Product> decreaseStock(
            @PathVariable UUID id,
            @Valid @RequestBody StockChangeRequest request) {
        Product product = productService.decreaseStock(id, request.quantity());
        return ResponseEntity.ok(product);
    }

    @GetMapping("/{id}/availability")
    public ResponseEntity<Map<String, Boolean>> checkAvailability(@PathVariable UUID id) {
        boolean available = productService.isProductAvailable(id);
        return ResponseEntity.ok(Map.of("available", available));
    }

    public record CreateProductRequest(
        @NotBlank String name,
        String description,
        @NotNull @Positive BigDecimal price,
        @NotBlank String category,
        @NotNull @Positive int stockQuantity
    ) {}

    public record UpdateProductRequest(
        @NotBlank String name,
        String description,
        @NotNull @Positive BigDecimal price,
        @NotBlank String category,
        @NotNull int stockQuantity
    ) {}

    public record StockChangeRequest(
        @NotNull @Positive int quantity
    ) {}
}