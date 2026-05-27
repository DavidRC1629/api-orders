# Usamos una imagen de Java ligera
FROM eclipse-temurin:17-jdk-alpine
# Copiamos el JAR generado por Maven
COPY target/*.jar app.jar
# Exponemos el puerto de la aplicación
EXPOSE 8080
# Comando para ejecutar
ENTRYPOINT ["java","-jar","/app.jar"]
