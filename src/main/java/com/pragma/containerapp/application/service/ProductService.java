package com.pragma.containerapp.application.service;

import com.pragma.containerapp.domain.model.Product;
import com.pragma.containerapp.domain.ports.ProductRepository;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(String name, String description, BigDecimal price,
                                  String category, int stockQuantity) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío");
        }
        if (price == null || price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor que cero");
        }
        if (stockQuantity < 0) {
            throw new IllegalArgumentException("La cantidad en stock no puede ser negativa");
        }
        if (productRepository.existsByName(name)) {
            throw new IllegalStateException("Ya existe un producto con el nombre: " + name);
        }

        Product product = new Product(
            name,
            description,
            price,
            LocalDate.now(),
            category,
            stockQuantity
        );

        return productRepository.save(product);
    }

    public Product updateProduct(UUID id, String name, String description,
                                  BigDecimal price, String category, int stockQuantity) {
        Optional<Product> existingProduct = productRepository.findById(id);
        if (existingProduct.isEmpty()) {
            throw new IllegalArgumentException("Producto no encontrado con ID: " + id);
        }

        Product product = existingProduct.get();
        Product updatedProduct = new Product(
            product.getId(),
            name,
            description,
            price,
            product.getCreatedAt(),
            category,
            stockQuantity
        );

        return productRepository.update(updatedProduct);
    }

    public Optional<Product> getProductById(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo");
        }
        return productRepository.findById(id);
    }

    public boolean deleteProduct(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo");
        }
        return productRepository.deleteById(id);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public List<Product> getProductsByCategory(String category) {
        if (category == null || category.isBlank()) {
            throw new IllegalArgumentException("La categoría no puede estar vacía");
        }
        return productRepository.findByCategory(category);
    }

    public List<Product> searchProductsByName(String nameFragment) {
        if (nameFragment == null || nameFragment.isBlank()) {
            throw new IllegalArgumentException("El fragmento de nombre no puede estar vacío");
        }
        return productRepository.findByNameContaining(nameFragment);
    }

    public Product increaseStock(UUID productId, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("La cantidad a incrementar debe ser mayor que cero");
        }
        return updateStock(productId, quantity);
    }

    public Product decreaseStock(UUID productId, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("La cantidad a decrementar debe ser mayor que cero");
        }
        Optional<Product> productOpt = productRepository.findById(productId);
        if (productOpt.isEmpty()) {
            throw new IllegalArgumentException("Producto no encontrado con ID: " + productId);
        }
        Product product = productOpt.get();
        if (product.getStockQuantity() < quantity) {
            throw new IllegalStateException("Stock insuficiente. Disponible: " + product.getStockQuantity()
                + ", solicitado: " + quantity);
        }
        return updateStock(productId, -quantity);
    }

    private Product updateStock(UUID productId, int quantityChange) {
        Product updated = productRepository.updateStock(productId, quantityChange);
        if (updated == null) {
            throw new IllegalStateException("No se pudo actualizar el stock del producto: " + productId);
        }
        return updated;
    }

    public boolean isProductAvailable(UUID productId) {
        return productRepository.findById(productId)
            .map(Product::isAvailable)
            .orElse(false);
    }
}