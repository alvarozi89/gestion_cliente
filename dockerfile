# Usamos una imagen oficial de Java 17
FROM openjdk:17-jdk-slim

# Establecemos el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiamos el archivo JAR generado por tu aplicación en el contenedor
COPY target/gestion.clientes.jar /app/gestion.clientes.jar

# Exponemos el puerto que usa tu aplicación (por defecto 8080)
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/gestion.clientes.jar"]
