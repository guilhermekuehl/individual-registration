FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/individual_registration-0.0.1-SNAPSHOT.jar /app/individual_registration-0.0.1-SNAPSHOT.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/individual_registration-0.0.1-SNAPSHOT.jar"]