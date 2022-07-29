FROM eclipse-temurin:18-jre-alpine
LABEL author="YawKar" version="1.0"
ARG JAR_FILE=target/*.jar
COPY $JAR_FILE /marvelCatalogApplication.jar
ENTRYPOINT ["java", "-jar", "/marvelCatalogApplication.jar"]