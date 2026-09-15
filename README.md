# Task Manager API

A Task Management RESTful API built with **Java 25** and **Spring Boot**, applying Domain-Driven Design (DDD) principles, Clean Architecture, and Bean Validation.

---

## 📌 Overview

The application allows users to create, list, inspect, update, and delete tasks. Each task has a unique identifier, title, optional description, and a lifecycle status (`PENDING`, `IN_PROGRESS`, `COMPLETED`).

An integrated, lightweight web interface is served directly by Spring Boot at the root path (`/`) for quick visual testing and management.

---

## 🚀 Tech Stack & Architecture

- **Language:** Java 25
- **Framework:** Spring Boot 4.x
- **Build Tool:** Maven
- **Persistence:** In-Memory repository (`ConcurrentHashMap`)
- **Key Patterns:**
  - **Clean Architecture / Hexagonal:** Strict separation between Domain, Application (Use Cases), and Infrastructure (HTTP & Repository).
  - **Domain-Driven Design (DDD):** Rich domain entities (`Task`), Value Objects (`TaskId`), and Enums (`TaskStatus`).
  - **Input Validation:** Jakarta Bean Validation on request payloads.

---

## 📁 Project Structure

```text
src/main/java/com/corsini/dio/taskmanager/
├── application/                # Application layer (Use Cases & DTOs)
│   ├── input/                  # Input boundaries / models
│   ├── output/                 # Output boundaries / projections
│   ├── CreateTaskUseCase.java
│   ├── DeleteTaskUseCase.java
│   ├── GetTaskByIdUseCase.java
│   ├── GetTaskUseCase.java
│   └── UpdateTaskUseCase.java
│
├── domain/                     # Core business logic & rules
│   ├── Task.java
│   ├── TaskId.java
│   ├── TaskRepository.java     # Repository interface (port)
│   ├── TaskStatus.java
│   └── TaskNotFoundException.java
│
└── infrastructure/             # Adapters & frameworks
    ├── http/                   # Web controllers & request/response DTOs
    └── repository/             # In-memory persistence implementation
```

---

## 📡 API Endpoints

Base Path: `/tasks`

| Method | Endpoint | Description | Request Body | Status Code |
| :--- | :--- | :--- | :--- | :--- |
| **POST** | `/tasks` | Create a new task | `{ "title": "...", "description": "..." }` | `200 OK` |
| **GET** | `/tasks` | List all tasks | *None* | `200 OK` |
| **GET** | `/tasks/{id}` | Get task by UUID | *None* | `200 OK` / `404 Not Found` |
| **PATCH** | `/tasks/{id}` | Partially update task | `{ "title": "...", "status": "..." }` | `200 OK` / `404 Not Found` |
| **DELETE**| `/tasks/{id}` | Delete task by UUID | *None* | `204 No Content` / `404 Not Found` |

### Task Statuses
- `PENDING` (initial default)
- `IN_PROGRESS`
- `COMPLETED`

---

## 🛠️ Getting Started

### Prerequisites
- **JDK 25** installed and configured in your `PATH`
- Maven (or use the provided `./mvnw` wrapper)

### Running the Application

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd taskmanager
   ```

2. Run with Maven wrapper:
   ```bash
   # On Linux / macOS
   ./mvnw spring-boot:run

   # On Windows (PowerShell / CMD)
   .\mvnw.cmd spring-boot:run
   ```

3. Access the application:
   - **Web UI:** [http://localhost:8080/](http://localhost:8080/)
   - **API Endpoints:** [http://localhost:8080/tasks](http://localhost:8080/tasks)