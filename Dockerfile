FROM eclipse-temurin:17 AS build
WORKDIR /app
COPY dart_league /app
RUN ./gradlew build -x test
FROM eclipse-temurin:17
COPY --from=build /app/build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]