# Utiliser une image de base Java
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY build/libs/ST2SCL_Project-0.0.1-SNAPSHOT.jar app.jar

# Exposer le port sur lequel l'application écoute
EXPOSE 8080

# Commande pour exécuter l'application
ENTRYPOINT ["java", "-jar", "app.jar"]