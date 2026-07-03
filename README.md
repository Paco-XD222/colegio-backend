# Examen Final de Tecnologias Emergentes SIS-414

Nombre: Cristian David Paco Bravo

RU: 107514

CI: 10468787

## Descripcion

Sistema web administrable para el Colegio Carlos Medinaceli. El backend expone servicios REST para administrar noticias, docentes, promociones, contactos y usuarios con login basico.

## Tecnologias Usadas

- Java 21
- Spring Boot 3.5.16
- Gradle Groovy
- Spring Data JPA
- PostgreSQL
- Springdoc OpenAPI / Swagger

## Modulos Implementados

- Noticias
- Docentes
- Promociones
- Contactos
- Usuarios/Login basico

## Endpoints Principales

- `/api/noticias`
- `/api/docentes`
- `/api/promociones`
- `/api/contactos`
- `/api/usuarios`
- `/api/usuarios/login`

Cada modulo CRUD incluye endpoints `GET`, `POST`, `PUT` y `DELETE` para listar, obtener por ID, crear, actualizar y eliminar registros.

## Como Ejecutar el Backend Localmente

1. Crear un archivo `.env` en la raiz del proyecto con las variables:

```properties
DB_URL=jdbc:postgresql://localhost:5432/nombre_base_datos
DB_USER=usuario
DB_PASSWORD=contrasena
```

2. Ejecutar el backend:

```powershell
.\gradlew.bat bootRun
```

3. Abrir Swagger en el navegador:

```text
http://localhost:8080/swagger-ui/index.html
```

## Swagger

URL local de Swagger:

```text
http://localhost:8080/swagger-ui/index.html
```
