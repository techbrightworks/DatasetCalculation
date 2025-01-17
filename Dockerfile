# Use a base image with JDK 17
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the jar file into the container
COPY target/dataset-calculation-0.0.1-SNAPSHOT.jar /app/dataset-calculation.jar

# Expose the port the application will run on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "dataset-calculation.jar"]