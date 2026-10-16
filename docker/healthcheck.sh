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