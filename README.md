# 👨‍💼 Employee Microservices Project

A **Java Spring Boot Microservices** project that manages employees and departments using a distributed microservices architecture.

The project is designed to demonstrate how multiple Spring Boot services communicate and discover each other using **Service Discovery** and centralized configuration.

---

## 🏗️ Architecture

The project consists of the following microservices:

```text
                    ┌─────────────────────┐
                    │   Config Server     │
                    │       :8888         │
                    └──────────┬──────────┘
                               │
                               │ Configuration
                               ▼
              ┌─────────────────────────────────┐
              │        Discovery Server         │
              │            Eureka               │
              │             :8761               │
              └───────────────┬─────────────────┘
                              │
                  ┌───────────┴───────────┐
                  │                       │
                  ▼                       ▼
       ┌──────────────────┐     ┌──────────────────┐
       │ Department       │     │ Employee         │
       │ Service          │     │ Service          │
       │                  │     │                  │
       │ Spring Boot      │     │ Spring Boot      │
       └────────┬─────────┘     └────────┬─────────┘
                │                        │
                └───────────┬────────────┘
                            ▼
                  ┌──────────────────┐
                  │   PostgreSQL     │
                  │     Database     │
                  └──────────────────┘
```

---

## 🚀 Microservices

### 1. 👨‍💻 Employee Service

Responsible for managing employee-related operations.

Main responsibilities:

* Create employees
* Retrieve employees
* Update employees
* Delete employees
* Manage employee information
* Communicate with the Department Service

---

### 2. 🏢 Department Service

Responsible for managing department-related operations.

Main responsibilities:

* Create departments
* Retrieve departments
* Update departments
* Delete departments
* Manage department information

---

### 3. 🔎 Discovery Server

The project uses **Netflix Eureka** for service discovery.

The Discovery Server allows microservices to register themselves and discover other services without relying on hard-coded hostnames or IP addresses.

```text
Employee Service
       │
       │ Register
       ▼
   Eureka Server
       ▲
       │ Register
       │
Department Service
```

This makes the architecture more flexible because services can communicate using service names instead of fixed addresses.

---

### 4. ⚙️ Config Server

The project uses **Spring Cloud Config Server** for centralized configuration management.

Instead of keeping configuration separately inside every microservice, configuration can be managed centrally.

```text
             Config Server
                  │
        ┌─────────┴─────────┐
        ▼                   ▼
 Employee Service    Department Service
```

This makes it easier to manage properties such as:

* Database configuration
* Server ports
* Service URLs
* Environment-specific configuration

---

## 🗄️ Database

The project uses **PostgreSQL** as the relational database.

The database stores information related to:

### Employee

Example fields:

```text
id
name
email
department_id
```

### Department

Example fields:

```text
id
name
```

---

## 🛠️ Technologies Used

* ☕ Java
* 🌱 Spring Boot
* ☁️ Spring Cloud
* 🔎 Eureka Service Discovery
* ⚙️ Spring Cloud Config Server
* 🗄️ PostgreSQL
* 📦 Maven
* 🔗 REST APIs

---

## 📁 Project Structure

```text
employee-microservice/
│
├── employee-service/
│   ├── src/
│   ├── pom.xml
│   └── ...
│
├── department-service/
│   ├── src/
│   ├── pom.xml
│   └── ...
│
├── discovery-server/
│   ├── src/
│   ├── pom.xml
│   └── ...
│
├── config-server/
│   ├── src/
│   ├── pom.xml
│   └── ...
│
└── README.md
```

---

## 🔄 How the Application Works

### Employee Request Example

A client sends a request to the Employee Service:

```http
GET /api/employees/1
```

The Employee Service processes the request and can communicate with the Department Service to retrieve department information.

For example:

```text
Client
  │
  │ GET Employee
  ▼
Employee Service
  │
  │ Find Department Service
  ▼
Eureka Discovery Server
  │
  │ Service Location
  ▼
Department Service
  │
  ▼
PostgreSQL
```

The services use **Eureka Service Discovery** to locate each other rather than depending on fixed service addresses.

---

## ⚙️ Configuration Flow

When a microservice starts:

```text
Microservice
     │
     │ Request configuration
     ▼
Config Server
     │
     │ Return configuration
     ▼
Microservice
     │
     │ Register itself
     ▼
Eureka Server
```

This provides centralized configuration and service discovery.

---

## ▶️ How to Run the Project

### 1. Clone the Repository

```bash
git clone <your-repository-url>
```

### 2. Start PostgreSQL

Make sure PostgreSQL is running and the required database has been created.

### 3. Start Config Server

Run the Config Server first:

```bash
mvn spring-boot:run
```

### 4. Start Discovery Server

Run the Eureka Discovery Server:

```bash
mvn spring-boot:run
```

The Eureka dashboard can be accessed through:

```text
http://localhost:8761
```

### 5. Start Department Service

Run the Department Service:

```bash
mvn spring-boot:run
```

### 6. Start Employee Service

Run the Employee Service:

```bash
mvn spring-boot:run
```

---

## 📡 REST API Examples

### Employee Service

#### Get Employee

```http
GET /api/employees/{id}
```

#### Get All Employees

```http
GET /api/employees
```

#### Create Employee

```http
POST /api/employees
```

Example request:

```json
{
  "name": "John Doe",
  "email": "john@example.com",
  "departmentId": 1
}
```

---

### Department Service

#### Get Department

```http
GET /api/departments/{id}
```

#### Get All Departments

```http
GET /api/departments
```

#### Create Department

```http
POST /api/departments
```

Example request:

```json
{
  "name": "Software Engineering"
}
```

---

## 🎯 Project Goals

This project demonstrates practical implementation of:

* Microservices architecture
* Service-to-service communication
* Service Discovery
* Centralized Configuration
* RESTful APIs
* Database integration
* Spring Boot application development
* PostgreSQL integration

---

## 🧠 Key Concepts Demonstrated

```text
Spring Boot
     │
     ├── Employee Service
     │
     ├── Department Service
     │
     ├── Eureka Discovery
     │
     ├── Config Server
     │
     └── PostgreSQL
```

The project demonstrates how independent Spring Boot services can work together as a distributed application while using **Eureka for service discovery** and **Spring Cloud Config for centralized configuration**.

---

## 👩‍💻 Author

**Nourhan Saeed**

Java Backend / Full-Stack Developer
