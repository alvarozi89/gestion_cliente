
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/gestion.clientes.jar /app/gestion.clientes.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/gestion.clientes.jar"]
