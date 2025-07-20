# Usa l'immagine OpenJDK 21, confermata come la tua versione di Java
FROM eclipse-temurin:21-jdk-jammy

# Imposta la directory di lavoro all'interno del container
WORKDIR /app

COPY target/footballTeam-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]