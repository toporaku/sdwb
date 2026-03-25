# Práctica 4 - Exception Handling

**Nombre:** Toporek Coca Eric
**Num de Cuenta:** 314284987

Este es un proyecto backend desarrollado en **Java usando Spring Boot**, el cual permite la administración de una entidad llamada `Categoría` de forma RESTful sobre una base de datos MySQL. Cuenta con capacidades de realizar un "soft-delete" de categorías y consultar listados activos e inactivos.

## � Changelog (Manejo de Excepciones - `p4_exception`)

Los principales cambios y características añadidas en esta versión (comparada con `p3_jpa`) son los siguientes:

- **Estructura Global de Errores**: Se creó el componente `RestExceptionHandler` (usando `@ControllerAdvice`) para interceptar y manejar las excepciones arrojadas por la aplicación a un nivel global, regresando un JSON estandarizado al cliente.
- **Objeto de Respuesta**: Se agregó la clase `ExceptionResponse` para estructurar la salida de los errores HTTP, conteniendo la fecha/hora exacta (`timestamp`), el código HTTP (`status`), el nombre del error (`error`), el mensaje detallado (`message`) y el `path` donde ocurrió el fallo.
- **Excepciones Personalizadas**: Creación de la clase `ApiException` (que hereda de `RuntimeException`) permitiéndonos disparar errores en la capa de servicios indicando explícitamente el código de estatus HTTP a devolver.
- **Adaptación en Servicios y Controladores**: Todo el flujo (`CtrlCategory`, `SvcCategory` y `SvcCategoryImp`) fue modificado para devolver objetos genéricos de modelo (`ResponseEntity<List<Category>>`), además de blindarse mediante la envoltura de consultas en bloques de `try/catch` para capturar explícitamente problemas con la base de datos (p.ej. `DataAccessException`).

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
