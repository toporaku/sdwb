# Practica 2
### Seminario de Desarrollo Web - Backend. Toporek Coca Eric 314284987

## Requisitos Previos

Para compilar y ejecutar este proyecto en tu máquina necesitas de lo siguiente:
- Java Development Kit (JDK) 14 o superior.
- Maven 3.6 o superior (aunque puedes usar el Wrapper del proyecto `mvnw`).

## Cómo ejecutar el proyecto sin uso de un IDE.

1. **Abre tu terminal** y sitúate sobre la carpeta raíz del proyecto (donde vive este `README.md`):
   ```bash
   cd sdwb
   ```

2. **Ejecuta el proyecto usando Maven (Spring Boot Plugin):**
   ```bash
   mvn spring-boot:run
   ```
   > ¡Listo! Si todo va bien, el servidor embebido (Tomcat) va a arrancar en el puerto `8080`.

3. **Haz una prueba rápida**.
   Dirígete a tu navegador y entra a:
   [http://localhost:8080/](http://localhost:8080/)
   Deberías ser redirigido al endpoint de category.

## Estructura de Paquetes
A grandes rasgos, así está estructurado todo bajo el source code `src/main/java/com/product/`:
- `model/` -> Entidad plana de Category.
- `repository/` -> Manejo y guardado de los datos simulados.
- `service/` -> Lógica operativa.
- `controller/` -> La capa REST que provee los endpoints y se conecta a HTTP.
