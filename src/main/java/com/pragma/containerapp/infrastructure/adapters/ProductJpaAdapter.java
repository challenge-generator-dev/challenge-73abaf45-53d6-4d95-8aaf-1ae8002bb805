package com.pragma.containerapp.infrastructure.adapters;

import com.pragma.containerapp.domain.model.Product;
import com.pragma.containerapp.domain.ports.ProductRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class ProductJpaAdapter implements ProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Product save(Product product) {
        if (product.getId() == null) {
            ProductEntity entity = toEntity(product);
            entityManager.persist(entity);
            return toDomain(entity);
        }
        return update(product);
    }

    @Override
    public Product update(Product product) {
        ProductEntity entity = toEntity(product);
        ProductEntity merged = entityManager.merge(entity);
        return toDomain(merged);
    }

    @Override
    public Optional<Product> findById(UUID id) {
        if (id == null) {
            return Optional.empty();
        }
        ProductEntity entity = entityManager.find(ProductEntity.class, id.toString());
        return Optional.ofNullable(entity).map(this::toDomain);
    }

    @Override
    public boolean deleteById(UUID id) {
        if (id == null) {
            return false;
        }
        ProductEntity entity = entityManager.find(ProductEntity.class, id.toString());
        if (entity != null) {
            entityManager.remove(entity);
            return true;
        }
        return false;
    }

    @Override
    public List<Product> findAll() {
        Query query = entityManager.createQuery("SELECT p FROM ProductEntity p", ProductEntity.class);
        List<ProductEntity> entities = query.getResultList();
        return entities.stream()
            .map(this::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public List<Product> findByCategory(String category) {
        Query query = entityManager.createQuery(
            "SELECT p FROM ProductEntity p WHERE p.category = :category",
            ProductEntity.class
        );
        query.setParameter("category", category);
        List<ProductEntity> entities = query.getResultList();
        return entities.stream()
            .map(this::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public List<Product> findByNameContaining(String nameFragment) {
        Query query = entityManager.createQuery(
            "SELECT p FROM ProductEntity p WHERE LOWER(p.name) LIKE LOWER(:name)",
            ProductEntity.class
        );
        query.setParameter("name", "%" + nameFragment + "%");
        List<ProductEntity> entities = query.getResultList();
        return entities.stream()
            .map(this::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public boolean existsByName(String name) {
        Query query = entityManager.createQuery(
            "SELECT COUNT(p) FROM ProductEntity p WHERE LOWER(p.name) = LOWER(:name)"
        );
        query.setParameter("name", name);
        Long count = (Long) query.getSingleResult();
        return count > 0;
    }

    @Override
    public Product updateStock(UUID productId, int quantityChange) {
        ProductEntity entity = entityManager.find(ProductEntity.class, productId.toString());
        if (entity == null) {
            return null;
        }
        int newStock = entity.getStockQuantity() + quantityChange;
        if (newStock < 0) {
            throw new IllegalStateException("Stock no puede ser negativo");
        }
        entity.setStockQuantity(newStock);
        entityManager.flush();
        return toDomain(entity);
    }

    private ProductEntity toEntity(Product product) {
        ProductEntity entity = new ProductEntity();
        if (product.getId() != null) {
            entity.setId(product.getId().toString());
        } else {
            entity.setId(UUID.randomUUID().toString());
        }
        entity.setName(product.getName());
        entity.setDescription(product.getDescription());
        entity.setPrice(product.getPrice());
        entity.setCreatedAt(product.getCreatedAt());
        entity.setCategory(product.getCategory());
        entity.setStockQuantity(product.getStockQuantity());
        return entity;
    }

    private Product toDomain(ProductEntity entity) {
        return new Product(
            UUID.fromString(entity.getId()),
            entity.getName(),
            entity.getDescription(),
            entity.getPrice(),
            entity.getCreatedAt(),
            entity.getCategory(),
            entity.getStockQuantity()
        );
    }

    @Entity
    private static class ProductEntity {
        private String id;
        private String name;
        private String description;
        private BigDecimal price;
        private LocalDate createdAt;
        private String category;
        private int stockQuantity;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        public LocalDate getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(LocalDate createdAt) {
            this.createdAt = createdAt;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public int getStockQuantity() {
            return stockQuantity;
        }

        public void setStockQuantity(int stockQuantity) {
            this.stockQuantity = stockQuantity;
        }
    }
}