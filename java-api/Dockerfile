FROM gradle:7.3-jdk11 AS build
WORKDIR /app
COPY build.gradle settings.gradle gradlew ./
COPY gradle ./gradle
COPY src ./src
RUN ./gradlew build --no-daemon

FROM openjdk:11
WORKDIR /app
COPY --from=build /app/build/libs/java-api-0.0.1-SNAPSHOT.jar ./java-api.jar
CMD ["java", "-jar", "java-api.jar"]

