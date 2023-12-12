FROM maven:3.9.1 AS MAVEN_BUILD
COPY . /build
WORKDIR /build
RUN mvn clean package

# Use AdoptOpenJDK 17 as the base image
FROM openjdk:17-alpine

# Set the working directory
WORKDIR /app

# Copy the JAR file from the MAVEN_BUILD stage
COPY --from=MAVEN_BUILD /build/target/*.jar /app/application.jar

# Expose the default Spring Boot port
EXPOSE 8080

# Entry point to run the application
ENTRYPOINT ["java", "-jar", "/app/application.jar"]