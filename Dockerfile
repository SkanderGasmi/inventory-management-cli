# Use latest OpenJDK 21 with slim OS for smaller image size
FROM eclipse-temurin:25-jdk-jammy

# Create a non-root user for security best practices
RUN groupadd -r appuser && useradd -r -g appuser appuser

# Set working directory inside container
WORKDIR /app

# Copy the JAR file from Maven target directory
COPY target/simple-inventory-1.0.0.jar /app/simple-inventory-1.0.0.jar

# Change ownership to non-root user
RUN chown -R appuser:appuser /app

# Switch to non-root user
USER appuser

# Expose port (optional for CLI applications)
# EXPOSE 8080

# Command to run the application with optimized JVM settings
CMD ["java", "-jar", "simple-inventory-1.0.0.jar"]
