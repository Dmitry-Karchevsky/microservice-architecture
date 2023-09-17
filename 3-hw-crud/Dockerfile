FROM openjdk:11 AS builder
ADD /target/3-hw-crud-1.0-SNAPSHOT.jar crud.jar
ENTRYPOINT ["java", "-jar", "crud.jar"]