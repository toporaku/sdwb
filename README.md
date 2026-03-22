# Práctica - CRUD Web y Validaciones

**Nombre:** Toporek Coca Eric
**Num de Cuenta:** 314284987

Este es un proyecto backend desarrollado en **Java usando Spring Boot**, el cual permite la administración de una entidad llamada `Categoría` de forma RESTful sobre una base de datos MySQL. Cuenta con capacidades de realizar un "soft-delete" de categorías y consultar listados activos e inactivos.

## 🆕 Changelog de la última versión

Los principales cambios y características añadidas a la aplicación son:

- **Operaciones CRUD Completas:** Adición de rutas REST en `CtrlCategory` para listar categorías activas (`GET /category/active`), crear (`POST /category`), actualizar (`PUT /category/{id}`), y cambiar de estado o *soft-delete* (`PATCH /category/{id}/enable` y `disable`).
- **Consultas Personalizadas JPA:** Creación de operaciones DML avanzadas mediante `@Query(nativeQuery = true)`, `@Modifying`, y `@Transactional` dentro de `RepoCategory` para un control exhaustivo sobre la base de datos.
- **Aislamiento de Lógica y DTOs:** Centralización de las transacciones hacia la base en `SvcCategoryImp`, que ahora procesa los envoltorios de entrada de usuario (`DtoCategroryIn`). 
- **Validaciones Spring Boot:** Se implementó `jakarta.validation` agregando la dependencia correspondiente a `pom.xml`, habilitando aserciones de consistencia en el API (p.ej. `@NotNull`).
- **Manejo Extensible de Excepciones (`DBAccessException` y HTTP 409):** Interceptamos activamente errores de restricción de unicidad de base de datos (`ux_category`, `ux_tag`) desde la extracción de la `DataAccessException`, devolviéndolo orgánicamente al usuario como conflictos `HttpStatus.CONFLICT`.

## �🚀 Requisitos Previos

Para ejecutar la aplicación localmente vas a necesitar:
- **Java 17 o superior** (configurado en el PATH o a través de SDKMAN).
- **Maven** (usualmente provisto con Spring Boot, o `mvn` independiente).
- **MySQL 9.x+** para servir la base de datos (con credenciales y base de datos configurados mediante el archivo SQL provisto).

## 🛠️ Configuración de la Base de Datos

Antes de arrancar la aplicación, debes proveer la base de datos, las credenciales, los permisos y opcionalmente los datos mock.

Encontrarás el archivo `src/sql/create_database.sql`. Puedes ejecutarlo directamente contra tu cliente de MySQL local iniciando sesión con root:

```bash
mysql -u root -p < src/sql/create_database.sql
```

**Lo que hace el archivo SQL es:**
1. Crear una base de datos llamada `SWDB2026`.
2. Crear la tabla pertinente de `category` con restricciones de tipo `UNIQUE`.
3. Crear un usuario de MySQL local llamado `swdb_admin` con contraseña.
4. Conceder los permisos de dicha base a este usuario.
5. Llenar la base de datos con unas cuantas categorías de prueba.

La aplicación conectará con esta base usando el perfil default que apunta a `jdbc:mysql://localhost:3306/SWDB2026` con dichas credenciales (a menos que lo cambies en `application.properties`).

## ⚙️ Cómo Compilar y Ejecutar

Con la base de datos y la versión de Java correctas en pie, ejecutar o compilar el proyecto es tan fácil como usar:

### 1) Compilación (Build)
Para compilar y descargar las dependencias de Maven, así como asegurar el código:
```bash
mvn clean install
```
> *(Para evitar ejecutar test largos en la etapa inicial puedes usar `mvn clean install -DskipTests`)*.

### 2) Ejecución
Puedes arrancar la aplicación usando la orden que expone el wrapper de Spring Boot por Maven:
```bash
mvn spring-boot:run
```
O de manera manual arrancando el `jar` resultante tras haber corrido `mvn clean install`:
```bash
java -jar target/product-0.0.1-SNAPSHOT.jar
```

## 🌐 Uso de la API
* La aplicación por defecto correrá en el puerto `8080`.
* Actualmente expone el Path REST asociado a las categorías: `http://localhost:8080/category`.
