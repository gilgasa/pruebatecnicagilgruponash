# 🛠️ Empleado Management API

API REST para la gestión de empleados, implementada en Java utilizando Spring Boot. Permite realizar operaciones CRUD sobre la entidad "Empleado" y está documentada con Swagger. Incluye manejo de excepciones y validaciones básicas.

Autor: Gilberto García Sánchez  
Contacto: gilgasan1@gmail.com

## Requerimientos de la Prueba Técnica 📋

### 1. ¿Qué es una API REST? 🌐
Una API REST (Representational State Transfer) es un tipo de API web que sigue los principios de la arquitectura REST. Las API REST utilizan métodos HTTP estándar (GET, POST, PUT, DELETE) para interactuar con los recursos, que son identificados mediante URLs. Los principios clave de REST incluyen la separación entre cliente y servidor, la statelessness (sin estado), la capacidad de caché, la utilización de una interfaz uniforme y la arquitectura en capas.

### 2. Principios de la arquitectura de microservicios 🏗️
La arquitectura de microservicios es un estilo de diseño de software que descompone una aplicación en pequeños servicios independientes, cada uno con su propia lógica de negocio y almacenamiento de datos. Los principios clave incluyen:
- **Descomposición en servicios**: Cada microservicio es una unidad funcional independiente.
- **Despliegue independiente**: Los microservicios pueden ser desplegados y escalados de forma autónoma.
- **Comunicación a través de APIs**: Los microservicios se comunican entre sí usando APIs, generalmente sobre HTTP/HTTPS.
- **Propiedad de datos independiente**: Cada microservicio gestiona su propia base de datos para evitar la interdependencia.
- **Automatización de despliegue**: Se promueve el uso de CI/CD para el despliegue continuo.

### 3. ¿Qué es una transacción en una base de datos y por qué es importante? 💾
Una transacción en una base de datos es una secuencia de operaciones que se ejecutan como una sola unidad lógica de trabajo. Las transacciones son importantes porque garantizan la integridad y consistencia de los datos mediante las propiedades ACID:
- **Atomicidad**: Todas las operaciones de una transacción se completan o ninguna se completa.
- **Consistencia**: Las transacciones llevan la base de datos de un estado consistente a otro.
- **Aislamiento**: Las operaciones dentro de una transacción son aisladas de otras transacciones.
- **Durabilidad**: Una vez que una transacción se ha completado, sus cambios son permanentes.

### 4. Diferencias entre bases de datos SQL y NoSQL 🗄️
- **SQL**: Son bases de datos relacionales que utilizan un esquema estructurado y tablas con filas y columnas. Ejemplos incluyen MySQL, PostgreSQL, y Oracle.
- **NoSQL**: Son bases de datos no relacionales que pueden usar diversos modelos de datos como documentos, grafos, clave-valor, y columnas. Ejemplos incluyen MongoDB, Cassandra, y Redis.

#### Situación para usar una base de datos SQL:
En una aplicación bancaria donde la consistencia y la integridad de los datos son críticas, y se necesita realizar operaciones complejas con JOINs.

#### Situación para usar una base de datos NoSQL:
En una aplicación de redes sociales que maneja grandes volúmenes de datos no estructurados y requiere escalabilidad horizontal, como almacenar publicaciones y comentarios en un formato de documento.

### 5. ¿Qué es un índice y su importancia en una base de datos? 📈
Un índice es una estructura de datos que mejora la velocidad de recuperación de registros en una tabla de base de datos. Los índices permiten acceder rápidamente a los datos sin tener que escanear toda la tabla, lo que mejora el rendimiento de las consultas. Sin embargo, los índices también pueden ralentizar las operaciones de inserción, actualización y eliminación, ya que la estructura del índice debe ser actualizada cada vez que cambian los datos.

### 6. Servicios de AWS útiles para desarrolladores backend ☁️
- **Amazon EC2**: Proporciona capacidad de cómputo escalable en la nube, permitiendo desplegar y gestionar servidores virtuales.
- **Amazon S3**: Servicio de almacenamiento de objetos que permite guardar y recuperar cualquier cantidad de datos desde cualquier lugar.
- **Amazon RDS**: Servicio de base de datos relacional que facilita la configuración, operación y escalabilidad de bases de datos en la nube.
- **AWS Lambda**: Permite ejecutar código sin aprovisionar ni gestionar servidores, ideal para arquitecturas de microservicios y aplicaciones serverless.
- **Amazon API Gateway**: Servicio para crear, publicar, mantener, monitorear y asegurar APIs a cualquier escala.
- **Amazon CloudWatch**: Proporciona monitoreo y gestión de logs y métricas para aplicaciones y recursos en AWS.

---

## Descripción del Proyecto 📄

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

## Diagramas de Arquitectura y Diseño

### Diagrama de Flujo del Sistema de Citas para Consultorio Médico

Este diagrama describe la lógica del proceso para agendar, reagendar o cancelar citas, así como el sistema de recordatorios automáticos.

![Diagrama de Flujo](https://pruebadimonds.s3.us-east-2.amazonaws.com/diagramaflujo.png)

### Diagrama de Componentes de AWS

Este diagrama muestra los componentes de AWS utilizados para el funcionamiento del sistema de gestión de citas para consultorio médico.

![Diagrama de Componentes de AWS](https://pruebadimonds.s3.us-east-2.amazonaws.com/Diagrama+AWS.png)

## Contacto

Gilberto García Sánchez  
gilgasan1@gmail.com
