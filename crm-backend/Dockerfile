# Étape 1 : Build du jar backend
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app
COPY pom.xml .
# Téléchargement des dépendances pour mettre en cache
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn package -DskipTests

# Étape 2 : Exécution de l'application
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=builder /app/target/crm-0.0.1-SNAPSHOT.jar app.jar

# Variables d'environnement par défaut
ENV SERVER_PORT=8081
ENV SPRING_DATASOURCE_URL=jdbc:mysql://mysql-db:3306/crm_digitrans?createDatabaseIfNotExist=true
ENV SPRING_DATASOURCE_USERNAME=dbadmin
ENV SPRING_DATASOURCE_PASSWORD=dbpassword
ENV JWT_SECRET=CamtechCrmSecretKey2026DigitransCM
ENV JWT_EXPIRATION=86400000

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]
