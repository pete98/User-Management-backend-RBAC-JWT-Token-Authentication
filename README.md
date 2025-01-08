# Employee Management Application

This is a Spring Boot application that provides a REST API for managing employee data. It features Role-Based Access Control (RBAC) to manage user permissions and JSON Web Token (JWT) authentication for secure access.

## Features

*   **Employee CRUD Operations:**
    *   Create new employee records.
    *   Retrieve employee details (individually or as a list).
    *   Update existing employee records.
    *   Delete employee records.
*   **Role-Based Access Control (RBAC):**
    *   **USER:** Can only view their own employee information.
    *   **ADMIN:** Can perform all CRUD operations on employee records.
    *   **SUPER\_ADMIN:** Can perform all CRUD operations on both employee and user records.
*   **JWT Authentication:**
    *   Secure API endpoints using JWT for authentication.
    *   Tokens are issued upon successful login.
    *   Tokens are validated for each request to protected resources.

## Technologies Used

*   **Java:** Programming language.
*   **Spring Boot:** Framework for building the REST API.
*   **Spring Security:** Framework for handling authentication and authorization (RBAC and JWT).
*   **Spring Data JPA:** For interacting with the database.
*   **JWT Library:** (e.g., jjwt) For generating and validating JWTs.
*   **Database:** MySQL
*   **Maven:** Build tool.
