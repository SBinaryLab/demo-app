        ## Build Stage ##
#FROM maven:3.8.7-openjdk-21-slim AS build
FROM maven:3.9.11-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

        ## Runtime Stage ##
#for resizing image and security purpose I use gcr.io/distroless/java21-debian1
FROM gcr.io/distroless/java21-debian12:nonroot
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
# Entrypoint
ENTRYPOINT ["java", "-jar", "app.jar"]
