# quizAppJava

A Spring Boot application for managing quiz questions and user authentication with JWT.

## Features

- User registration, login, and password update
- JWT-based authentication and authorization
- CRUD operations for quiz questions
- Filter questions by category and difficulty
- PostgreSQL database integration

## Endpoints

### User

- `POST /user/register` — Register a new user
- `PUT /user/updatePassword` — Update user password
- `POST /user/generateJwtToken` — Generate JWT token for login

### Questions

- `GET /questions` — Get all questions
- `GET /questions/category/{category}` — Get questions by category
- `GET /questions/difficultyLevel?level={level}` — Get questions by difficulty
- `POST /questions` — Add a new question

## Getting Started

### Prerequisites

- Java 17+
- Maven
- PostgreSQL

### Setup

1. Clone the repository.
2. Configure your database in [`src/main/resources/application.properties`](src/main/resources/application.properties).
3. Build and run the application:

   ```sh
   ./mvnw spring-boot:run