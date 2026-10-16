package com.pragma.containerapp.domain.ports;

import com.pragma.containerapp.domain.model.Product;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Puerto del dominio que define las operaciones de persistencia para productos.
 * Esta interfaz es implementada por la capa de infraestructura y utilizada
 * por la capa de aplicación para interactuar con los datos de productos.
 */
public interface ProductRepository {
    /**
     * Guarda un nuevo producto en el repositorio.
     *
     * @param product Producto a guardar
     * @return Producto guardado con su ID generado
     */
    Product save(Product product);

    /**
     * Actualiza la información de un producto existente.
     *
     * @param product Producto con la información actualizada
     * @return Producto actualizado
     * @throws IllegalArgumentException si el producto no existe
     */
    Product update(Product product);

    /**
     * Busca un producto por su identificador único.
     *
     * @param id Identificador del producto
     * @return Optional que contiene el producto si existe, vacío en caso contrario
     */
    Optional<Product> findById(UUID id);

    /**
     * Elimina un producto del repositorio.
     *
     * @param id Identificador del producto a eliminar
     * @return true si el producto fue eliminado, false si no existía
     */
    boolean deleteById(UUID id);

    /**
     * Lista todos los productos disponibles.
     *
     * @return Lista de todos los productos
     */
    List<Product> findAll();

    /**
     * Lista productos por categoría.
     *
     * @param category Categoría a filtrar
     * @return Lista de productos de la categoría especificada
     */
    List<Product> findByCategory(String category);

    /**
     * Busca productos cuyo nombre contenga el texto especificado (búsqueda parcial).
     *
     * @param nameFragment Fragmento de texto a buscar en los nombres
     * @return Lista de productos cuyo nombre contiene el fragmento
     */
    List<Product> findByNameContaining(String nameFragment);

    /**
     * Verifica si existe un producto con el nombre especificado.
     *
     * @param name Nombre del producto a verificar
     * @return true si existe un producto con ese nombre, false en caso contrario
     */
    boolean existsByName(String name);

    /**
     * Actualiza la cantidad en stock de un producto.
     *
     * @param productId Identificador del producto
     * @param quantityChange Cantidad a sumar/restar (puede ser negativo)
     * @return Producto con la cantidad actualizada
     * @throws IllegalArgumentException si el producto no existe o si la cantidad resultante es negativa
     */
    Product updateStock(UUID productId, int quantityChange);
}