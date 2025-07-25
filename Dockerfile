FROM eclipse-temurin:17-jdk AS builder

USER root

WORKDIR /app
COPY --chmod=0755 mvnw mvnw
COPY .mvn/ .mvn/
COPY . .

RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY --from=builder /app/target/*jar app.jar

EXPOSE 8080

#remove -agentlib, is only used when debugging
ENTRYPOINT ["java","-jar","app.jar"]