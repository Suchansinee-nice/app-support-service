# Development stage with Eclipse Temurin 8 on Alpine
FROM eclipse-temurin:21-jdk-alpine AS development

WORKDIR /usr/src/app

# Copy the Maven Wrapper and pom.xml
COPY .mvn/ .mvn/
COPY mvnw mvnw
COPY mvnw.cmd mvnw.cmd
COPY pom.xml .

# Copy the application source
COPY src/ src/

# Ensure the Maven Wrapper is executable
RUN chmod +x mvnw

# Use Maven Wrapper to resolve dependencies
RUN ./mvnw dependency:go-offline

# Build the application, skipping tests
RUN ./mvnw clean install -DskipTests

# Production stage with Eclipse Temurin 8 JRE on Alpine
FROM eclipse-temurin:21-jdk-alpine AS production

# Set the working directory
WORKDIR /usr/src/app

# Copy the built artifacts from the development stage
COPY --from=development /usr/src/app/target/osr-support-service-0.0.1-SNAPSHOT.war ./app.war

# Expose the port Spring Boot application listens on (default is 8080)
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "app.war"]