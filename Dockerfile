FROM maven:3.9.7-eclipse-temurin-22 AS build

RUN mkdir /app
COPY . ./app
WORKDIR /app

RUN mvn clean install

FROM openjdk:23-ea-22-jdk-bookworm AS runtime
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
EXPOSE 8080

