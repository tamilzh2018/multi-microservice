FROM openjdk:11
WORKDIR /app
COPY . .
RUN ./gradlew build
CMD ["java", "-jar", "build/libs/java-api-0.0.1-SNAPSHOT.jar"]
