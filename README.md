# 🛠️ Empleado Management API

API REST para la gestión de empleados, implementada en Java utilizando Spring Boot. Permite realizar operaciones CRUD sobre la entidad "Empleado" y está documentada con Swagger. Incluye manejo de excepciones y validaciones básicas.

Autor: Gilberto García Sánchez  
Contacto: gilgasan1@gmail.com

## Descripción 📄

Esta API permite gestionar empleados dentro de una empresa. Proporciona endpoints para crear, leer, actualizar y eliminar empleados. Cada empleado tiene los siguientes atributos:

- `id`: Identificador único del empleado.
- `nombre`: Nombre del empleado.
- `puesto`: Puesto del empleado.
- `salario`: Salario del empleado.
- `fechaContratacion`: Fecha de contratación del empleado.

## Endpoints 🚀

### Obtener todos los empleados

- **URL**: `/api/empleados`
- **Método**: GET
- **Ejemplo de Respuesta**:
    ```json
    [
        {
            "id": 1,
            "nombre": "Juan Pérez",
            "puesto": "Desarrollador",
            "salario": 50000,
            "fechaContratacion": "2020-01-01"
        },
        {
            "id": 2,
            "nombre": "Ana Gómez",
            "puesto": "Analista",
            "salario": 40000,
            "fechaContratacion": "2019-05-15"
        }
    ]
    ```

### Obtener un empleado por ID

- **URL**: `/api/empleados/{id}`
- **Método**: GET
- **Ejemplo de Respuesta**:
    ```json
    {
        "id": 1,
        "nombre": "Juan Pérez",
        "puesto": "Desarrollador",
        "salario": 50000,
        "fechaContratacion": "2020-01-01"
    }
    ```

### Crear un nuevo empleado

- **URL**: `/api/empleados`
- **Método**: POST
- **Cuerpo de Solicitud**:
    ```json
    {
        "nombre": "Carlos López",
        "puesto": "Ingeniero",
        "salario": 45000,
        "fechaContratacion": "2023-01-01"
    }
    ```
- **Ejemplo de Respuesta**:
    ```json
    {
        "id": 3,
        "nombre": "Carlos López",
        "puesto": "Ingeniero",
        "salario": 45000,
        "fechaContratacion": "2023-01-01"
    }
    ```

### Actualizar un empleado existente

- **URL**: `/api/empleados/{id}`
- **Método**: PUT
- **Cuerpo de Solicitud**:
    ```json
    {
        "nombre": "Carlos López",
        "puesto": "Ingeniero Senior",
        "salario": 50000,
        "fechaContratacion": "2023-01-01"
    }
    ```
- **Ejemplo de Respuesta**:
    ```json
    {
        "id": 3,
        "nombre": "Carlos López",
        "puesto": "Ingeniero Senior",
        "salario": 50000,
        "fechaContratacion": "2023-01-01"
    }
    ```

### Eliminar un empleado

- **URL**: `/api/empleados/{id}`
- **Método**: DELETE
- **Ejemplo de Respuesta**: `204 No Content`

## Requisitos de la Prueba Técnica ✅

- [x] Correcta implementación de los endpoints (GET, POST, PUT, DELETE).
- [x] Uso de un framework de backend (Spring Boot).
- [x] Calidad y claridad del código, incluyendo comentarios.
- [x] Uso adecuado de respuestas HTTP y manejo de Excepciones.
- [x] Conectar la API a la base de datos (H2 en memoria para esta prueba técnica).
- [x] Implementación de validaciones básicas.

## Cómo Empezar 🚀

### Prerrequisitos

- [Java JDK 8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
- [Apache Maven](https://maven.apache.org/)
- [Spring Boot](https://spring.io/projects/spring-boot)

### Instalación

1. Clona el repositorio:
    ```bash
    git clone https://github.com/gilgasa/pruebatecnicagilgruponas.git
    cd pruebatecnicagilgruponas
    ```

2. Compila y ejecuta la aplicación:
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

3. Accede a la aplicación:
    - La API estará disponible en `http://localhost:8080/api/empleados`
    - La documentación Swagger estará disponible en `http://localhost:8080/swagger-ui/`
    - La consola H2 estará disponible en `http://localhost:8080/h2-console` (usuario: `sa`, contraseña: `password`)

## Capturas de Pantalla 📸

### Swagger UI

![Swagger UI](https://pruebadimonds.s3.us-east-2.amazonaws.com/swagger.png)

### Consola H2

![Consola H2](https://pruebadimonds.s3.us-east-2.amazonaws.com/h2.png)

## Contacto

Gilberto García Sánchez  
gilgasan1@gmail.com
