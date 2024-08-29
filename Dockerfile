FROM eclipse-temurin:17-jdk-alpine
WORKDIR /file_service
COPY build/libs/. .
CMD java -jar file_service.jar