package com.pragma.containerapp.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

/**
 * Entidad del dominio que representa un producto en el sistema.
 * Contiene toda la información relevante para la gestión de productos
 * y sus restricciones de negocio.
 */
public class Product {
    private final UUID id;

    @NotBlank(message = "El nombre del producto no puede estar vacío")
    @Size(max = 100, message = "El nombre del producto no puede exceder 100 caracteres")
    private final String name;

    @NotBlank(message = "La descripción del producto no puede estar vacía")
    @Size(max = 500, message = "La descripción del producto no puede exceder 500 caracteres")
    private final String description;

    @NotNull(message = "El precio del producto no puede ser nulo")
    @Positive(message = "El precio del producto debe ser positivo")
    private final BigDecimal price;

    @NotNull(message = "La fecha de creación no puede ser nula")
    private final LocalDate createdAt;

    @NotNull(message = "La categoría del producto no puede ser nula")
    @Size(max = 50, message = "La categoría no puede exceder 50 caracteres")
    private final String category;

    @PositiveOrZero(message = "La cantidad en stock no puede ser negativa")
    private final int stockQuantity;

    /**
     * Constructor principal para crear una nueva instancia de Product.
     * Valida todas las restricciones de negocio antes de crear el objeto.
     *
     * @param id Identificador único del producto
     * @param name Nombre del producto
     * @param description Descripción detallada del producto
     * @param price Precio del producto
     * @param createdAt Fecha de creación del producto
     * @param category Categoría del producto
     * @param stockQuantity Cantidad disponible en stock
     */
    public Product(UUID id, String name, String description, BigDecimal price,
                  LocalDate createdAt, String category, int stockQuantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.createdAt = createdAt;
        this.category = category;
        this.stockQuantity = stockQuantity;

        validateBusinessRules();
    }

    /**
     * Constructor alternativo para crear un producto con ID generado automáticamente.
     *
     * @param name Nombre del producto
     * @param description Descripción detallada del producto
     * @param price Precio del producto
     * @param category Categoría del producto
     * @param stockQuantity Cantidad disponible en stock
     */
    public Product(String name, String description, BigDecimal price,
                  String category, int stockQuantity) {
        this(UUID.randomUUID(), name, description, price,
            LocalDate.now(), category, stockQuantity);
    }

    /**
     * Valida las reglas de negocio del producto.
     * Lanza IllegalArgumentException si alguna regla no se cumple.
     */
    private void validateBusinessRules() {
        if (price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor que cero");
        }
        if (stockQuantity < 0) {
            throw new IllegalArgumentException("La cantidad en stock no puede ser negativa");
        }
        if (createdAt.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de creación no puede ser futura");
        }
    }

    // Getters para todos los atributos
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public String getCategory() {
        return category;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    /**
     * Crea una nueva instancia de Product con la cantidad en stock actualizada.
     *
     * @param newQuantity Nueva cantidad en stock
     * @return Nueva instancia de Product con la cantidad actualizada
     */
    public Product withStockQuantity(int newQuantity) {
        return new Product(this.id, this.name, this.description, this.price,
                          this.createdAt, this.category, newQuantity);
    }

    /**
     * Verifica si el producto está disponible para venta.
     *
     * @return true si hay stock disponible, false en caso contrario
     */
    public boolean isAvailable() {
        return stockQuantity > 0;
    }

    @Override
    public String toString() {
        return "Product[id=" + id +
               ", name='" + name + '\'' +
               ", price=" + price +
               ", category='" + category + '\'' +
               ", stock=" + stockQuantity + "]";
    }
}