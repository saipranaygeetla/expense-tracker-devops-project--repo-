# Base Image
FROM eclipse-temurin:17-jre

# Working Directory
WORKDIR /app

# Copy JAR
COPY target/*.jar app.jar

# Application Port
EXPOSE 8080

# Start Application
ENTRYPOINT ["java","-jar","app.jar"]