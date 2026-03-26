# Simple Todo API

Une API REST Spring Boot simple pour la gestion de tâches, facile à déployer.

## Fonctionnalités

- **GET** `/api/todos` - Liste toutes les tâches
- **GET** `/api/todos/{id}` - Récupère une tâche par ID
- **POST** `/api/todos` - Crée une nouvelle tâche
- **PUT** `/api/todos/{id}` - Met à jour une tâche
- **PATCH** `/api/todos/{id}/complete` - Marque une tâche comme complétée
- **DELETE** `/api/todos/{id}` - Supprime une tâche
- **DELETE** `/api/todos` - Supprime toutes les tâches
- **GET** `/api/todos/health` - Vérifie l'état de l'application

## Démarrage Rapide

### Option 1 : Maven (Local)

```bash
# Compiler et exécuter
mvn spring-boot:run

# Ou compiler puis exécuter
mvn clean package
java -jar target/simple-todo-api-1.0.0.jar
```

### Option 2 : Docker (Recommandé pour le déploiement)

```bash
# Construire l'image
docker build -t simple-todo-api .

# Exécuter le conteneur
docker run -p 8080:8080 simple-todo-api
```

## Test de l'API

```bash
# Créer une tâche
curl -X POST http://localhost:8080/api/todos \
  -H "Content-Type: application/json" \
  -d '{"title":"Apprendre Spring Boot","description":"Créer une API REST"}'

# Lister les tâches
curl http://localhost:8080/api/todos

# Health check
curl http://localhost:8080/api/todos/health
```

## Structure du Projet

```
spring-todo-api/
├── src/
│   └── main/
│       ├── java/com/example/todo/
│       │   ├── TodoApplication.java
│       │   ├── controller/TodoController.java
│       │   ├── model/Todo.java
│       │   └── service/TodoService.java
│       └── resources/
│           └── application.properties
├── Dockerfile
├── pom.xml
└── README.md
```

## Technologies

- Java 17
- Spring Boot 3.2.0
- Spring Web
- Spring Validation
- Spring Actuato
# Spring-Boot_jenkins
