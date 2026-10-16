# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener un ZIP con el proyecto completo y arrancable.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Superficie de practica — NO resuelvas

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs.

- `docker/Dockerfile` — El topic pide contenedores/orquestacion: este archivo es el ejercicio, no scaffolding.
- `docker/docker-compose.yml` — El topic pide contenedores/orquestacion: este archivo es el ejercicio, no scaffolding.
- `k8s/deployment.yml` — El topic pide contenedores/orquestacion: este archivo es el ejercicio, no scaffolding.
- `k8s/service.yml` — El topic pide contenedores/orquestacion: este archivo es el ejercicio, no scaffolding.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `src/main/java/com/pragma/containerapp/infrastructure/adapters/ProductJpaAdapter.java` — `ProductEntity.getStockQuantity`: Se invoca `getStockQuantity` sobre `ProductEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/containerapp/infrastructure/adapters/ProductJpaAdapter.java` — `ProductEntity.setStockQuantity`: Se invoca `setStockQuantity` sobre `ProductEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/containerapp/infrastructure/adapters/ProductJpaAdapter.java` — `ProductEntity.setId`: Se invoca `setId` sobre `ProductEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/containerapp/infrastructure/adapters/ProductJpaAdapter.java` — `ProductEntity.setName`: Se invoca `setName` sobre `ProductEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/containerapp/infrastructure/adapters/ProductJpaAdapter.java` — `ProductEntity.setDescription`: Se invoca `setDescription` sobre `ProductEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/containerapp/infrastructure/adapters/ProductJpaAdapter.java` — `ProductEntity.setPrice`: Se invoca `setPrice` sobre `ProductEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/containerapp/infrastructure/adapters/ProductJpaAdapter.java` — `ProductEntity.setCreatedAt`: Se invoca `setCreatedAt` sobre `ProductEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/containerapp/infrastructure/adapters/ProductJpaAdapter.java` — `ProductEntity.setCategory`: Se invoca `setCategory` sobre `ProductEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/containerapp/infrastructure/adapters/ProductJpaAdapter.java` — `ProductEntity.getId`: Se invoca `getId` sobre `ProductEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/containerapp/infrastructure/adapters/ProductJpaAdapter.java` — `ProductEntity.getName`: Se invoca `getName` sobre `ProductEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/containerapp/infrastructure/adapters/ProductJpaAdapter.java` — `ProductEntity.getDescription`: Se invoca `getDescription` sobre `ProductEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/containerapp/infrastructure/adapters/ProductJpaAdapter.java` — `ProductEntity.getPrice`: Se invoca `getPrice` sobre `ProductEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/containerapp/infrastructure/adapters/ProductJpaAdapter.java` — `ProductEntity.getCreatedAt`: Se invoca `getCreatedAt` sobre `ProductEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/containerapp/infrastructure/adapters/ProductJpaAdapter.java` — `ProductEntity.getCategory`: Se invoca `getCategory` sobre `ProductEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/containerapp/infrastructure/controllers/ProductController.java` — `StockChangeRequest.name`: Se invoca `name` sobre `StockChangeRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/containerapp/infrastructure/controllers/ProductController.java` — `StockChangeRequest.description`: Se invoca `description` sobre `StockChangeRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/containerapp/infrastructure/controllers/ProductController.java` — `StockChangeRequest.price`: Se invoca `price` sobre `StockChangeRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/containerapp/infrastructure/controllers/ProductController.java` — `StockChangeRequest.category`: Se invoca `category` sobre `StockChangeRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/containerapp/infrastructure/controllers/ProductController.java` — `StockChangeRequest.stockQuantity`: Se invoca `stockQuantity` sobre `StockChangeRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/containerapp/infrastructure/controllers/ProductController.java` — `StockChangeRequest.quantity`: Se invoca `quantity` sobre `StockChangeRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

## Como saber que terminaste

```bash
mvn clean compile
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Backend, Especialidad Desarrollador, Tecnología Java, Advanced

### Brecha de conocimiento
Implementa la contenerización y orquestación de contenedores en proyectos, teniendo en cuenta las diferencias, ventajas y desventajas de cada enfoque. Utiliza al menos dos herramientas de contenerización/orquestación, como Docker, Docker Compose, Docker Swarm, K8s (Kubernetes) u OpenShift

### Misión / candidato
Candidato Advanced con experiencia en desarrollo backend con Java

### Reto
- Tema: Implementa Plataformas de Contenedores enfocados en Docker y Kubernetes
- Seniority: advanced-l2
- Tipo: practical
- Título: Implementación de Contenedores y Orquestación en Proyectos
- Tiempo estimado: 15 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Configuración de Docker — objetivo: Configurar y ejecutar contenedores usando Docker. — entregable (NO resolver): Dockerfile y contenedor ejecutándose.
- Fase 2: Orquestación con Docker Compose — objetivo: Configurar y ejecutar una aplicación multi-contenedor usando Docker Compose. — entregable (NO resolver): Archivo docker-compose.yml y aplicación multi-contenedor ejecutándose.
- Fase 3: Orquestación con Kubernetes — objetivo: Configurar y ejecutar una aplicación en Kubernetes. — entregable (NO resolver): Manifests de Kubernetes y aplicación desplegada en Minikube.
- Fase 4: Comparación y Decisiones — objetivo: Comparar Docker Compose y Kubernetes, y tomar decisiones informadas sobre cuándo usar cada herramienta. — entregable (NO resolver): Informe comparativo y recomendaciones.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (ZIP).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.5.6</version>
        <relativePath/>
    </parent>

    <groupId>com.pragma</groupId>
    <artifactId>container-app</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>container-app</name>
    <description>Proyecto de contenerización y orquestación con Docker y Kubernetes</description>

    <properties>
        <java.version>21</java.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
            <version>2.6.0</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <excludes>
                        <exclude>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </exclude>
                    </excludes>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/main/java/com/pragma/containerapp/ContainerAppApplication.java ===
package com.pragma.containerapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ContainerAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContainerAppApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*");
            }
        };
    }
}

// === ARCHIVO: src/main/resources/application.yml ===
spring:
  application:
    name: container-app
  datasource:
    url: jdbc:postgresql://localhost:5432/container_db
    username: postgres
    password: postgres
    driver-class-name: org.postgresql.Driver
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true
        dialect: org.hibernate.dialect.PostgreSQLDialect
  docker:
    compose:
      lifecycle-management: start-only
      file: docker/docker-compose.yml

management:
  endpoints:
    web:
      exposure:
        include: health,info,metrics,prometheus
  endpoint:
    health:
      probes:
        enabled: true
      show-details: always

server:
  port: 8080
  servlet:
    context-path: /api

springdoc:
  api-docs:
    path: /api-docs
  swagger-ui:
    path: /swagger-ui.html
    operations-sorter: method

// === ARCHIVO: src/main/java/com/pragma/containerapp/domain/model/Product.java ===
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

// === ARCHIVO: src/main/java/com/pragma/containerapp/domain/ports/ProductRepository.java ===
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

// === ARCHIVO: src/main/java/com/pragma/containerapp/application/service/ProductService.java ===
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

// === ARCHIVO: src/main/java/com/pragma/containerapp/infrastructure/adapters/ProductJpaAdapter.java ===
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

// === ARCHIVO: src/main/java/com/pragma/containerapp/infrastructure/controllers/ProductController.java ===
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

// === ARCHIVO: docker/Dockerfile ===
# Stage 1: Build
FROM eclipse-temurin:21-jdk-alpine AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN apk add --no-cache maven && mvn clean package -DskipTests

# Stage 2: Runtime
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

// === ARCHIVO: docker/.dockerignore ===
target/
!.mvn/wrapper/maven-wrapper.jar
!**/src/main/**/target/
!**/src/test/**/target/

### STS ###
.apt_generated
.classpath
.factorypath
.project
.settings
.springBeans
.sts4-cache

### IntelliJ IDEA ###
.idea
*.iws
*.iml
*.ipr

### NetBeans ###
/nbproject/private/
/nbbuild/
/dist/
/nbdist/
/.nb-gradle/
build/
!**/src/main/**/build/
!**/src/test/**/build/

### VS Code ###
.vscode/

### Maven ###
pom.xml.tag
pom.xml.releaseBackup
pom.xml.versionsBackup
pom.xml.next
release.properties
dependency-reduced-pom.xml
buildNumber.properties
.mvn/timing.properties
.mvn/wrapper/maven-wrapper.jar

### Logs ###
*.log
logs/

### OS ###
.DS_Store
Thumbs.db

### Kubernetes ###
k8s/
*.kubeconfig

### Docker ###
docker-compose.override.yml
.docker/

### Environment ###
.env.local
.env.*.local

### Test reports ###
test-output/
 Surefire reports/

// === ARCHIVO: docker/docker-compose.yml ===
version: '3.8'

services:
  app:
    build:
      context: ..
      dockerfile: docker/Dockerfile
    ports:
      - "8080:8080"
    environment:
      - SPRING_PROFILES_ACTIVE=docker
    depends_on:
      db:
        condition: service_healthy

  db:
    image: postgres:16-alpine
    environment:
      - POSTGRES_DB=containerapp
      - POSTGRES_USER=pragma
      - POSTGRES_PASSWORD=pragma123
    ports:
      - "5432:5432"
    volumes:
      - postgres_data:/var/lib/postgresql/data
    healthcheck:
      test: ["CMD-SHELL", "pg_isready -U pragma -d containerapp"]
      interval: 10s
      timeout: 5s
      retries: 5

volumes:
  postgres_data:

// === ARCHIVO: docker/healthcheck.sh ===
#!/bin/bash
set -e

echo "[HEALTHCHECK] Iniciando verificación de salud del contenedor..."

# Configuración del endpoint de healthcheck
HEALTH_ENDPOINT="${HEALTH_ENDPOINT:-http://localhost:8080/actuator/health}"
MAX_RETRIES="${MAX_RETRIES:-30}"
RETRY_INTERVAL="${RETRY_INTERVAL:-2}"
TIMEOUT="${TIMEOUT:-5}"

echo "[HEALTHCHECK] Endpoint configurado: $HEALTH_ENDPOINT"
echo "[HEALTHCHECK] Reintentos máximos: $MAX_RETRIES"
echo "[HEALTHCHECK] Intervalo entre reintentos: ${RETRY_INTERVAL}s"

# Función para verificar la respuesta HTTP
check_health() {
    local response
    local http_code
    
    response=$(curl -s -f -w "\n%{http_code}" --max-time "$TIMEOUT" "$HEALTH_ENDPOINT" 2>/dev/null) || return 1
    
    http_code=$(echo "$response" | tail -n1)
    
    if [ "$http_code" = "200" ]; then
        local body
        body=$(echo "$response" | sed '$d')
        echo "[HEALTHCHECK] Respuesta recibida: $body"
        
        # Verificar el estado dentro del JSON de respuesta
        local status
        status=$(echo "$body" | grep -o '"status":"[^"]*"' | cut -d'"' -f4)
        
        if [ "$status" = "UP" ]; then
            echo "[HEALTHCHECK] Estado de la aplicación: UP"
            return 0
        else
            echo "[HEALTHCHECK] Estado de la aplicación: $status (no UP)"
            return 1
        fi
    else
        echo "[HEALTHCHECK] Código HTTP inesperado: $http_code"
        return 1
    fi
}

# Función para verificar la conectividad a la base de datos
check_database() {
    local db_host="${DB_HOST:-localhost}"
    local db_port="${DB_PORT:-5432}"
    
    echo "[HEALTHCHECK] Verificando conectividad a PostgreSQL en $db_host:$db_port"
    
    if command -v nc &> /dev/null; then
        nc -z -w "$TIMEOUT" "$db_host" "$db_port" 2>/dev/null
    elif command -v timeout &> /dev/null; then
        timeout "$TIMEOUT" bash -c "echo > /dev/tcp/$db_host/$db_port" 2>/dev/null
    else
        echo "[HEALTHCHECK] ADVERTENCIA: No se puede verificar PostgreSQL (nc/timeout no disponible)"
        return 0
    fi
    
    if [ $? -eq 0 ]; then
        echo "[HEALTHCHECK] PostgreSQL accesible"
        return 0
    else
        echo "[HEALTHCHECK] PostgreSQL no accesible"
        return 1
    fi
}

# Función principal de retry
retry_healthcheck() {
    local attempt=1
    
    while [ $attempt -le $MAX_RETRIES ]; do
        echo "[HEALTHCHECK] Intento $attempt de $MAX_RETRIES"
        
        if check_health; then
            echo "[HEALTHCHECK] Verificación de salud exitosa"
            
            # Verificar base de datos si está configurada
            if [ "${DB_HOST:-none}" != "none" ]; then
                check_database || echo "[HEALTHCHECK] ADVERTENCIA: Verificación de DB falló"
            fi
            
            echo "[HEALTHCHECK] Contenedor saludable"
            exit 0
        fi
        
        echo "[HEALTHCHECK] Fallo en intento $attempt, esperando ${RETRY_INTERVAL}s..."
        sleep "$RETRY_INTERVAL"
        attempt=$((attempt + 1))
    done
    
    echo "[HEALTHCHECK] ERROR: No se pudo verificar la salud después de $MAX_RETRIES intentos"
    exit 1
}

# Verificar que curl está disponible
if ! command -v curl &> /dev/null; then
    echo "[HEALTHCHECK] ERROR: curl no está instalado"
    exit 1
fi

# Ejecutar el healthcheck con reintentos
retry_healthcheck

// === ARCHIVO: k8s/deployment.yml ===
apiVersion: apps/v1
kind: Deployment
metadata:
  name: container-app
  labels:
    app: container-app
spec:
  replicas: 2
  selector:
    matchLabels:
      app: container-app
  template:
    metadata:
      labels:
        app: container-app
        version: v1
    spec:
      containers:
      - name: container-app
        image: container-app:latest
        imagePullPolicy: IfNotPresent
        ports:
        - containerPort: 8080
          name: http
          protocol: TCP
        env:
        - name: SPRING_PROFILES_ACTIVE
          value: "k8s"
        - name: DB_HOST
          valueFrom:
            configMapKeyRef:
              name: container-app-config
              key: db.host
        - name: DB_PORT
          valueFrom:
            configMapKeyRef:
              name: container-app-config
              key: db.port
        - name: DB_NAME
          valueFrom:
            configMapKeyRef:
              name: container-app-config
              key: db.name
        - name: DB_USERNAME
          valueFrom:
            secretKeyRef:
              name: container-app-secret
              key: db.username
        - name: DB_PASSWORD
          valueFrom:
            secretKeyRef:
              name: container-app-secret
              key: db.password
        resources:
          requests:
            memory: "512Mi"
            cpu: "250m"
          limits:
            memory: "1Gi"
            cpu: "500m"
        livenessProbe:
          httpGet:
            path: /actuator/health/liveness
            port: 8080
          initialDelaySeconds: 60
          periodSeconds: 10
          timeoutSeconds: 5
          failureThreshold: 3
        readinessProbe:
          httpGet:
            path: /actuator/health/readiness
            port: 8080
          initialDelaySeconds: 30
          periodSeconds: 5
          timeoutSeconds: 3
          failureThreshold: 3

// === ARCHIVO: k8s/service.yml ===
apiVersion: v1
kind: Service
metadata:
  name: container-app-service
  labels:
    app: container-app
spec:
  type: ClusterIP
  selector:
    app: container-app
  ports:
  - name: http
    port: 80
    targetPort: 8080
    protocol: TCP
---
apiVersion: v1
kind: Service
metadata:
  name: container-app-nodeport
  labels:
    app: container-app
spec:
  type: NodePort
  selector:
    app: container-app
  ports:
  - name: http
    port: 8080
    targetPort: 8080
    nodePort: 30080
    protocol: TCP

// === ARCHIVO: README.md ===
# Container App - Proyecto de Contenerización y Orquestación

Este proyecto es una aplicación Spring Boot configurada para ejecutarse en contenedores Docker y ser orquestada mediante Docker Compose y Kubernetes.

## Prerrequisitos

Para ejecutar este proyecto necesitas tener instalados los siguientes herramientas:

- **Java 21** - Entorno de ejecución Java
- **Maven 3.9+** - Gestor de dependencias y construcción
- **Docker 24+** - Plataforma de contenedores
- **Docker Compose 2.24+** - Orquestación de contenedores
- **kubectl** - Cliente de Kubernetes
- **Minikube** (opcional) - Para ejecutar Kubernetes localmente
- **PostgreSQL 15+** - Base de datos del proyecto

## Estructura del Proyecto

```
container-app/
├── src/
│   ├── main/
│   │   ├── java/com/pragma/containerapp/
│   │   │   ├── domain/           # Capa de dominio (modelos, puertos)
│   │   │   ├── application/      # Capa de aplicación (servicios, casos de uso)
│   │   │   ├── infrastructure/   # Capa de infraestructura (adaptadores, controladores)
│   │   │   └── ContainerAppApplication.java
│   │   └── resources/
│   │       └── application.yml   # Configuración de la aplicación
│   └── test/                     # Pruebas unitarias
├── docker/
│   ├── Dockerfile                # Imagen Docker de la aplicación
│   ├── .dockerignore             # Archivos excluidos en la build
│   ├── docker-compose.yml        # Orquestación multi-contenedor
│   └── healthcheck.sh            # Script de verificación de salud
├── k8s/
│   ├── deployment.yml            # Manifest de despliegue K8s
│   └── service.yml               # Manifest de servicio K8s
└── pom.xml                       # Configuración Maven
```

## Construcción del Proyecto

### Compilación Local

Para compilar el proyecto sin ejecutar:

```bash
mvn clean compile
```

Para construir el JAR ejecutable:

```bash
mvn clean package -DskipTests
```

El JAR generado se ubicará en `target/container-app-0.0.1-SNAPSHOT.jar`.

### Ejecución Local (sin contenedores)

```bash
mvn spring-boot:run
```

La aplicación arrancará en `http://localhost:8080`.

## Docker

### Construir la Imagen

Desde la raíz del proyecto:

```bash
docker build -f docker/Dockerfile -t container-app:latest .
```

### Ejecutar el Contenedor

```bash
docker run -p 8080:8080 \
  -e SPRING_DATASOURCE_URL=jdbc:postgresql://host.docker.internal:5432/containerapp \
  -e SPRING_DATASOURCE_USERNAME=postgres \
  -e SPRING_DATASOURCE_PASSWORD=postgres \
  --network host \
  container-app:latest
```

## Docker Compose

### Iniciar la Aplicación Completa

```bash
cd docker
docker-compose up --build
```

Esto levantará:
- Aplicación Spring Boot en el puerto 8080
- Base de datos PostgreSQL en el puerto 5432
- Health check configurado

### Verificar el Estado

```bash
docker-compose ps
docker-compose logs -f app
```

### Detener los Contenedores

```bash
docker-compose down
```

## Kubernetes

### Requisitos Previos

- Minikube instalado y en ejecución: `minikube start`
- kubectl configurado para comunicarse con el cluster

### Desplegar en Minikube

```bash
# Aplicar los manifests
kubectl apply -f k8s/

# Verificar el despliegue
kubectl get pods
kubectl get services

# Ver logs de la aplicación
kubectl logs -l app=container-app
```

### Acceder a la Aplicación

```bash
# Exponer el servicio localmente
minikube service container-app-service
```

### Escalar la Aplicación

```bash
kubectl scale deployment container-app-deployment --replicas=3
```

### Limpiar Recursos

```bash
kubectl delete -f k8s/
```

## Variables de Entorno

| Variable | Descripción | Valor Predeterminado |
|----------|-------------|---------------------|
| SPRING_DATASOURCE_URL | URL de conexión a PostgreSQL | jdbc:postgresql://localhost:5432/containerapp |
| SPRING_DATASOURCE_USERNAME | Usuario de la base de datos | postgres |
| SPRING_DATASOURCE_PASSWORD | Contraseña de la base de datos | postgres |
| SERVER_PORT | Puerto de la aplicación | 8080 |

## Health Checks

La aplicación expone endpoints de salud mediante Spring Boot Actuator:

- **Health general**: `GET /actuator/health`
- **Info**: `GET /actuator/info`

El Dockerfile incluye un healthcheck que verifica el endpoint de salud cada 30 segundos.

## API REST

La API REST está documentada con OpenAPI/Swagger:

- **Swagger UI**: `http://localhost:8080/swagger-ui.html`
- **OpenAPI JSON**: `http://localhost:8080/v3/api-docs`

## Comandos Útiles

### Verificar imagen Docker
```bash
docker images | grep container-app
```

### Eliminar imágenes huérfanas
```bash
docker system prune -a
```

### Ver recursos de Kubernetes
```bash
kubectl get all -l app=container-app
kubectl describe deployment container-app-deployment
```

### Logs en tiempo real
```bash
# Docker
docker-compose logs -f app

# Kubernetes
kubectl logs -f deployment/container-app-deployment
```

## Resolución de Problemas

### La aplicación no inicia en Docker
- Verificar que PostgreSQL esté accesible desde el contenedor
- Comprobar las variables de entorno configuradas
- Revisar los logs: `docker-compose logs app`

### Error de conexión a la base de datos
- Verificar que PostgreSQL esté ejecutándose
- Confirmar credenciales en las variables de entorno
- Comprobar la red de Docker

### Problemas con Kubernetes
- Asegurar que Minikube esté activo: `minikube status`
- Verificar que los manifests no tengan errores de sintaxis
- Revisar eventos del namespace: `kubectl get events`

## Referencias

- [Documentación de Spring Boot](https://docs.spring.io/spring-boot/docs/current/reference/)
- [Docker Docs](https://docs.docker.com/)
- [Kubernetes Docs](https://kubernetes.io/docs/home/)
- [Docker Compose Reference](https://docs.docker.com/compose/reference/)
```
