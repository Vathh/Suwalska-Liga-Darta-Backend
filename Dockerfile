FROM eclipse-temurin:17
COPY /dart_league/build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]