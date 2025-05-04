# 🔐 Broken Access Control - OWASP Demo (Java Spring Boot)

Este repositorio contiene dos versiones de una misma aplicación web desarrollada con **Spring Boot**, destinadas a demostrar la vulnerabilidad de **Broken Access Control**, uno de los principales riesgos de seguridad web según [OWASP Top 10](https://owasp.org/www-project-top-ten/).

## 📂 Contenido del repositorio

.
├── broken-access-control-demo/ # ❌ Versión vulnerable
├── broken-access-control-secure/ # ✅ Versión corregida
└── README.md # Este archivo

markdown
Copiar
Editar

## ❌ Versión vulnerable (`broken-access-control-demo`)

Esta versión simula una autenticación básica con usuarios fijos, pero no implementa ninguna **verificación de roles** ni controles en el backend para proteger las rutas sensibles.

### 🧪 Vulnerabilidad demostrada

Cualquier usuario autenticado puede acceder a la ruta `/admin`, independientemente de su rol.

### 🧍 Usuarios simulados

| Usuario | Contraseña  | Descripción         |
|---------|-------------|---------------------|
| admin   | adminpass   | Supuesto administrador |
| user    | userpass    | Usuario normal         |

> **Nota:** no se usan roles ni autenticación real. Solo se guarda el nombre de usuario en la sesión.

## ✅ Versión segura (`broken-access-control-secure`)

Esta versión implementa una verificación de acceso al endpoint `/admin`, permitiendo el acceso **solo al usuario "admin"**.

### ✅ Cambios realizados

- Verificación explícita del nombre de usuario en `/admin`
- Redirección a `/dashboard` si el usuario no tiene privilegios

## ▶️ Instrucciones para ejecutar

Ambas versiones pueden ejecutarse con:

```bash
./mvnw spring-boot:run
Asegúrate de ejecutar el comando dentro del directorio de cada versión (broken-access-control-demo o broken-access-control-secure).

Luego, accede a:
👉 http://localhost:8080/
