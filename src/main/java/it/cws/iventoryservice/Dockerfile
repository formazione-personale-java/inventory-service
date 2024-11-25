# Étape 1 : Utilisation de l'image OpenJDK 21 slim
FROM openjdk:21-jdk-slim AS base

# Étape 2 : Métadonnées de l'image Docker
LABEL \
  maintainer="votre-email@domain.com" \
  version="1.0" \
  description="Spring Boot Application for Inventory Management" \
  repository="https://github.com/votre-utilisateur/mon-application" \
  org.opencontainers.image.source="https://github.com/votre-utilisateur/mon-application" \
  org.opencontainers.image.version="1.0" \
  org.opencontainers.image.licenses="MIT" \
  org.opencontainers.image.created="2024-11-25"

# Étape 3 : Spécification du répertoire de travail dans le conteneur
WORKDIR /app

# Étape 4 : Copier tous les fichiers .jar depuis le répertoire target
# et les renommer en inventory.jar
COPY target/*.jar /app/inventory.jar

# Étape 5 : Définir les variables d'environnement
# Configurez le port de l'application et la configuration de la JVM
ENV SERVER_PORT=8082 \
    JAVA_OPTS="-Xms512m -Xmx1024m"

# Étape 6 : Exposer le port 8082 sur lequel l'application écoute
EXPOSE 8082

# Étape 7 : Utilisation de la commande ENTRYPOINT pour démarrer l'application
# L'argument -jar est utilisé pour exécuter le fichier .jar renommé en inventory.jar
ENTRYPOINT ["java", "-jar", "/app/inventory.jar"]

# Étape 8 : (Optionnel) CMD permet d'ajouter des arguments supplémentaires par défaut
CMD ["--server.port=${SERVER_PORT}"]
