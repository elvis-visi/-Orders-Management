# Start with the official Maven image as the base
FROM maven:3.8.3-openjdk-11-slim AS build

# Set the working directory inside the container
WORKDIR /build

# Copy the pom.xml file
COPY pom.xml .

# Download the dependencies
RUN mvn dependency:go-offline

# Copy the source code
COPY src/ /build/src/

# Build the application
RUN mvn clean package

# Use the OpenJDK image for the runtime
FROM openjdk:11-jre-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /build/target/*.jar app.jar

# Expose the port on which your application will run
EXPOSE 8080

# Start the application
ENTRYPOINT ["java", "-jar", "app.jar"]
