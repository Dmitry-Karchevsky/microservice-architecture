FROM openjdk:11 AS builder
ADD /target/microservice-architecture.jar backend.jar
ENTRYPOINT ["java", "-jar", "backend.jar"]