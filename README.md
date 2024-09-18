# Food Delivery Microservice

This project is a food delivery microservice application built with Spring Boot and MySQL. It consists of multiple microservices that handle different aspects of the application, including users, food, and orders. The microservices communicate with each other via REST APIs and utilize Feign clients for inter-service communication.

## Microservices Overview

1. **User Service**: Manages user information and authentication.
2. **Food Service**: Manages food items available for ordering.
3. **Order Service**: Handles orders placed by users.

## Technologies Used

- **Spring Boot**: For creating stand-alone, production-grade Spring-based applications.
- **MySQL**: Relational database management system for storing data.
- **Feign Client**: For making HTTP requests between microservices.
- **Spring Security**: For securing the microservices (if implemented).

## Getting Started

### Prerequisites

- Java 17 or later
- MySQL 8.x or later
- Maven 3.x or later

### Configuration

1. **Clone the repository:**

   ```sh
   git clone https://github.com/your-username/food-delivery-microservice.git
   cd food-delivery-microservice

2. **Create the database:**

  ```
  CREATE DATABASE user_service_db;
  CREATE DATABASE food_service_db;
  CREATE DATABASE order_service_db;
  ```

3. **Configure application properties:**
   Update the application.properties file in each microservice with your MySQL connection details. Example configuration for food-service:
  ```
  spring.datasource.url=jdbc:mysql://localhost:3306/food_service_db
  spring.datasource.username=root
  spring.datasource.password=password
 ```

### Access the APIs

User Service: http://localhost:8081/auth/users
Food Service: http://localhost:8082/api/food
Order Service: http://localhost:8083/api/orders
