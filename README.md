# Implementación de Contenedores y Orquestación en Proyectos

Implementa la contenerización y orquestación de contenedores en proyectos, teniendo en cuenta las diferencias, ventajas y desventajas de cada enfoque. Utiliza al menos dos herramientas de contenerización/orquestación, como Docker, Docker Compose, Docker Swarm, K8s (Kubernetes) u OpenShift.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Implementa Plataformas de Contenedores enfocados en Docker y Kubernetes |
| **Nivel** | advanced-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 15 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Configuración de Docker

**Objetivo:** Configurar y ejecutar contenedores usando Docker.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Instala Docker en tu entorno de desarrollo.
- Crea un Dockerfile para una aplicación simple.
- Construye y ejecuta el contenedor.
- Verifica que el contenedor se ejecuta correctamente.

**Entregable:** Dockerfile y contenedor ejecutándose.

<details>
<summary>Pistas de conocimiento</summary>

- Considera las mejores prácticas para escribir Dockerfiles.
- Investiga cómo optimizar la construcción de imágenes de Docker.

</details>

### Fase 2: Orquestación con Docker Compose

**Objetivo:** Configurar y ejecutar una aplicación multi-contenedor usando Docker Compose.

**Tiempo estimado:** 4 horas

**Instrucciones:**

- Crea un archivo docker-compose.yml para una aplicación con múltiples servicios.
- Define las dependencias y relaciones entre los servicios.
- Ejecuta la aplicación usando Docker Compose.
- Verifica que todos los servicios se ejecutan correctamente y que las dependencias se respetan.

**Entregable:** Archivo docker-compose.yml y aplicación multi-contenedor ejecutándose.

<details>
<summary>Pistas de conocimiento</summary>

- Investiga las diferentes opciones de configuración disponibles en Docker Compose.
- Considera cómo manejar las dependencias entre servicios.

</details>

### Fase 3: Orquestación con Kubernetes

**Objetivo:** Configurar y ejecutar una aplicación en Kubernetes.

**Tiempo estimado:** 4 horas

**Instrucciones:**

- Instala Minikube para ejecutar un clúster local de Kubernetes.
- Crea los manifests de Kubernetes para los servicios de tu aplicación.
- Despliega los servicios en el clúster de Kubernetes.
- Verifica que todos los servicios se ejecutan correctamente y que las dependencias se respetan.

**Entregable:** Manifests de Kubernetes y aplicación desplegada en Minikube.

<details>
<summary>Pistas de conocimiento</summary>

- Investiga las diferentes opciones de configuración disponibles en Kubernetes.
- Considera cómo manejar las dependencias entre servicios en Kubernetes.

</details>

### Fase 4: Comparación y Decisiones

**Objetivo:** Comparar Docker Compose y Kubernetes, y tomar decisiones informadas sobre cuándo usar cada herramienta.

**Tiempo estimado:** 4 horas

**Instrucciones:**

- Investiga las diferencias, ventajas y desventajas de Docker Compose y Kubernetes.
- Escribe un informe comparando ambos enfoques.
- Identifica escenarios donde cada herramienta es más adecuada.
- Proporciona recomendaciones para futuros proyectos.

**Entregable:** Informe comparativo y recomendaciones.

<details>
<summary>Pistas de conocimiento</summary>

- Considera factores como escalabilidad, complejidad, facilidad de uso y costos.
- Investiga casos de uso reales donde se han utilizado Docker Compose y Kubernetes.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es Docker y Kubernetes y para qué se utilizan?
- **paraQueSirve**: ¿Para qué sirve Docker Compose en comparación con Kubernetes?
- **comoSeUsa**: ¿Cómo se utiliza Docker para contenerizar aplicaciones?
- **erroresComunes**: ¿Cuáles son los errores comunes al usar Docker y Kubernetes?
- **queDecisionesImplica**: ¿Qué decisiones implica elegir entre Docker Compose y Kubernetes para un proyecto?

## Criterios de Evaluacion

- Configurar y ejecutar contenedores usando Docker.
- Configurar y ejecutar una aplicación multi-contenedor usando Docker Compose.
- Configurar y ejecutar una aplicación en Kubernetes.
- Comparar Docker Compose y Kubernetes y tomar decisiones informadas.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT). Devuelve un ZIP con el proyecto. Sirve si no tenes un agente en el IDE.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn clean compile
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
