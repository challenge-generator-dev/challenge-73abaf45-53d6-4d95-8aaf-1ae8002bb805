# AGENTS.md

Instrucciones para el agente de IA que abra este repositorio (Claude Code, Cursor, Codex, Copilot, Gemini). Se cargan solas: no hay que pegar nada en ningun chat.

## Que es este repositorio

Es el codigo base de un reto de aprendizaje de Pragma: **Implementación de Contenedores y Orquestación en Proyectos**.

| | |
|---|---|
| Tema | Implementa Plataformas de Contenedores enfocados en Docker y Kubernetes |
| Nivel | advanced-l2 |
| Chapter | Backend |
| Especialidad | Java |
| Stack | Java / Spring Boot 3.5 |
| Patron arquitectonico | capas estándar |
| Tiempo estimado | 15 horas |

## Receta del stack

Esqueleto obligatorio:

- `pom.xml en la raiz`
- `clase con @SpringBootApplication`
- `application.yml en src/main/resources`
- `capa de dominio con entidades y puertos`
- `capa de aplicacion con casos de uso`
- `capa de infraestructura con adaptadores y @RestController`

Trampas conocidas:

- TODA `<version>` del pom va con tres segmentos: la del parent (ej. `3.5.6`) y la de cada dependencia que la lleve (ej. Resilience4j `2.2.0`). `3.4` y `2.0` no existen como artefacto y el build muere resolviendo dependencias.
- Las dependencias que el parent POM gestiona van SIN `<version>`: `spring-boot-starter-web`, `-data-jpa`, `-validation`, `-test`, etc.
- Resilience4j publica un artefacto por linea de Spring Boot. Con Spring Boot 3 va `resilience4j-spring-boot3` con version de tres segmentos (ej. `2.2.0`, no `2.0`). `resilience4j-spring-boot2` es de Spring Boot 2 y rompe el arranque.
- Si usas anotaciones de validacion (`@NotNull`, `@Size`, `@Positive`) declara `spring-boot-starter-validation`: el starter web no las trae.
- El `spring-boot-maven-plugin` tiene que estar en `<build><plugins>` o no se empaqueta ejecutable.
- Spring Boot 3 usa `jakarta.*`, nunca `javax.*`.
- Cada archivo empieza con su `package` y con un `import` por cada clase del proyecto que viva en otro paquete. Usar `PaymentService` desde `infrastructure` sin `import com.x.application.PaymentService` no compila.

Dependencias:

- org.springframework.boot:spring-boot-starter-web 3.5.6
- org.springframework.boot:spring-boot-starter-data-jpa n/a
- org.springframework.boot:spring-boot-starter-validation n/a
- org.springframework.boot:spring-boot-starter-test n/a
- org.postgresql:postgresql 42.7.3
- org.projectlombok:lombok 1.18.34

## Tu tarea

Dejar este proyecto en estado **verificable**: que el comando de verificacion corra sin errores. Escribi los archivos en disco, en este repositorio. No generes ZIPs ni archivos adjuntos.

En orden:

1. Corre `mvn clean compile` y mira que falla.
2. Completa lo que falte de la lista de abajo: manifiesto de dependencias, punto de entrada, capa de interfaz y las capas del patron declarado.
3. Arregla SOLO los errores que impiden compilar o arrancar.
4. Volve a correr `mvn clean compile` hasta que pase.
5. Pará ahí.

## Regla dura: las fases son trabajo del humano

**PROHIBIDO implementar los entregables de las fases.** El valor del reto esta en que la persona los resuelva. Tu trabajo es que tenga un proyecto que arranca; el hueco pedagogico se queda como esta.

No resuelvas nada de esto:

- **Fase 1 — Configuración de Docker**: Dockerfile y contenedor ejecutándose.
- **Fase 2 — Orquestación con Docker Compose**: Archivo docker-compose.yml y aplicación multi-contenedor ejecutándose.
- **Fase 3 — Orquestación con Kubernetes**: Manifests de Kubernetes y aplicación desplegada en Minikube.
- **Fase 4 — Comparación y Decisiones**: Informe comparativo y recomendaciones.

Distincion operativa:

- **Arreglar** (si): import faltante, tipo que no existe, dependencia sin declarar, error de sintaxis, archivo referenciado que no existe.
- **No tocar** (no): logica de negocio incompleta, validaciones ausentes, secretos hardcodeados, APIs deprecadas que funcionan, concurrencia insegura, patrones mejorables. Eso es lo que la persona tiene que encontrar.

## Superficie de practica (NO completes)

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs. No toques la logica que el reto pide completar.

- [ ] `docker/Dockerfile` — El topic pide contenedores/orquestacion: este archivo es el ejercicio, no scaffolding.
- [ ] `docker/docker-compose.yml` — El topic pide contenedores/orquestacion: este archivo es el ejercicio, no scaffolding.
- [ ] `k8s/deployment.yml` — El topic pide contenedores/orquestacion: este archivo es el ejercicio, no scaffolding.
- [ ] `k8s/service.yml` — El topic pide contenedores/orquestacion: este archivo es el ejercicio, no scaffolding.

## Lo que falta y tenes que completar

### 1. Referencias colgando (20)

Salieron de un analisis estatico del codigo que SI esta en el repo. Cada una rompe la compilacion:

- [ ] `src/main/java/com/pragma/containerapp/infrastructure/adapters/ProductJpaAdapter.java` — `ProductEntity.getStockQuantity`
      Se invoca `getStockQuantity` sobre `ProductEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/containerapp/infrastructure/adapters/ProductJpaAdapter.java` — `ProductEntity.setStockQuantity`
      Se invoca `setStockQuantity` sobre `ProductEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/containerapp/infrastructure/adapters/ProductJpaAdapter.java` — `ProductEntity.setId`
      Se invoca `setId` sobre `ProductEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/containerapp/infrastructure/adapters/ProductJpaAdapter.java` — `ProductEntity.setName`
      Se invoca `setName` sobre `ProductEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/containerapp/infrastructure/adapters/ProductJpaAdapter.java` — `ProductEntity.setDescription`
      Se invoca `setDescription` sobre `ProductEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/containerapp/infrastructure/adapters/ProductJpaAdapter.java` — `ProductEntity.setPrice`
      Se invoca `setPrice` sobre `ProductEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/containerapp/infrastructure/adapters/ProductJpaAdapter.java` — `ProductEntity.setCreatedAt`
      Se invoca `setCreatedAt` sobre `ProductEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/containerapp/infrastructure/adapters/ProductJpaAdapter.java` — `ProductEntity.setCategory`
      Se invoca `setCategory` sobre `ProductEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/containerapp/infrastructure/adapters/ProductJpaAdapter.java` — `ProductEntity.getId`
      Se invoca `getId` sobre `ProductEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/containerapp/infrastructure/adapters/ProductJpaAdapter.java` — `ProductEntity.getName`
      Se invoca `getName` sobre `ProductEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/containerapp/infrastructure/adapters/ProductJpaAdapter.java` — `ProductEntity.getDescription`
      Se invoca `getDescription` sobre `ProductEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/containerapp/infrastructure/adapters/ProductJpaAdapter.java` — `ProductEntity.getPrice`
      Se invoca `getPrice` sobre `ProductEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/containerapp/infrastructure/adapters/ProductJpaAdapter.java` — `ProductEntity.getCreatedAt`
      Se invoca `getCreatedAt` sobre `ProductEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/containerapp/infrastructure/adapters/ProductJpaAdapter.java` — `ProductEntity.getCategory`
      Se invoca `getCategory` sobre `ProductEntity`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/containerapp/infrastructure/controllers/ProductController.java` — `StockChangeRequest.name`
      Se invoca `name` sobre `StockChangeRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/containerapp/infrastructure/controllers/ProductController.java` — `StockChangeRequest.description`
      Se invoca `description` sobre `StockChangeRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/containerapp/infrastructure/controllers/ProductController.java` — `StockChangeRequest.price`
      Se invoca `price` sobre `StockChangeRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/containerapp/infrastructure/controllers/ProductController.java` — `StockChangeRequest.category`
      Se invoca `category` sobre `StockChangeRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/containerapp/infrastructure/controllers/ProductController.java` — `StockChangeRequest.stockQuantity`
      Se invoca `stockQuantity` sobre `StockChangeRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/com/pragma/containerapp/infrastructure/controllers/ProductController.java` — `StockChangeRequest.quantity`
      Se invoca `quantity` sobre `StockChangeRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

### Presentes (15)

- `pom.xml`
- `src/main/java/com/pragma/containerapp/ContainerAppApplication.java`
- `src/main/resources/application.yml`
- `src/main/java/com/pragma/containerapp/domain/model/Product.java`
- `src/main/java/com/pragma/containerapp/domain/ports/ProductRepository.java`
- `src/main/java/com/pragma/containerapp/application/service/ProductService.java`
- `src/main/java/com/pragma/containerapp/infrastructure/adapters/ProductJpaAdapter.java`
- `src/main/java/com/pragma/containerapp/infrastructure/controllers/ProductController.java`
- `docker/Dockerfile`
- `docker/.dockerignore`
- `docker/docker-compose.yml`
- `docker/healthcheck.sh`
- `k8s/deployment.yml`
- `k8s/service.yml`
- `README.md`

### Capas del patron declarado

Cada una tiene que existir como directorio real con al menos un archivo. Codigo plano en la raiz no satisface el patron.

- `src/main/java/com/pragma/containerapp`
- `src/main/java/com/pragma/containerapp/application`
- `src/main/java/com/pragma/containerapp/domain`
- `src/main/java/com/pragma/containerapp/infrastructure`
- `src/main/resources`
- `k8s`
- `docker`

## Verificacion

```bash
mvn clean compile
```

El comando tiene que pasar SIN implementar los archivos de la superficie de practica: solo andamiaje.

Ese comando pasando es la definicion de "terminado" para vos.

## Convenciones que tenes que respetar

- Un solo ecosistema: no declares librerias de otro lenguaje ni mezcles gestores de paquetes.
- Toda libreria que uses tiene que estar declarada en el manifiesto de dependencias.
- Todo import declarado tiene que usarse; todo tipo usado tiene que existir o venir de una dependencia declarada.
- El patron es **capas estándar**: los contratos (interfaces, puertos) los define la capa interna y los implementa la externa, nunca al revés.
- Los archivos que crees llevan implementacion real, no stubs: sin `TODO`, sin cuerpos vacios, sin `// getters y setters`.

## Contexto del candidato

Sirve para calibrar el nivel del codigo, no para resolver las fases.

- Perfil: Chapter Backend, Especialidad Desarrollador, Tecnología Java, Advanced
- Brecha que el reto ataca: Implementa la contenerización y orquestación de contenedores en proyectos, teniendo en cuenta las diferencias, ventajas y desventajas de cada enfoque. Utiliza al menos dos herramientas de contenerización/orquestación, como Docker, Docker Compose, Docker Swarm, K8s (Kubernetes) u OpenShift
- Mision: Candidato Advanced con experiencia en desarrollo backend con Java

---

*Generado por Challenge Generator — Pragma. `README.md` tiene el enunciado completo del reto para la persona. `PROMPT_MEJORA.md` es la variante para pegar en un chat, si se prefiere ese flujo.*
