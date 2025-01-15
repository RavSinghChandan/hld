# Use an official Java runtime as a parent image
FROM openjdk:17-jdk-slim as build

# Set the working directory in the container
WORKDIR /app

# Copy the local project files to the container
COPY . /app

# Install Maven and build the Spring Boot application
RUN apt-get update && apt-get install -y maven
RUN mvn clean install

# Expose the port the app will run on
EXPOSE 8080

# Set environment variables for Spring Boot
ENV SPRING_PROFILES_ACTIVE=prod
ENV SPRING_APPLICATION_NAME=hld
ENV SPRING_DATASOURCE_URL=jdbc:h2:mem:testdb
ENV SPRING_DATASOURCE_DRIVERCLASSNAME=org.h2.Driver
ENV SPRING_DATASOURCE_USERNAME=sa
ENV SPRING_DATASOURCE_PASSWORD=password
ENV SPRING_JPA_DATABASEPLATFORM=org.hibernate.dialect.H2Dialect
ENV SPRING_H2_CONSOLE_ENABLED=true
ENV SPRINGDOC_SWAGGER_UI_PATH=/swagger-ui/index.html

# Run the application
CMD ["java", "-jar", "target/spring-hld-app.jar"]
