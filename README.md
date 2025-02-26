# Employee Management Application
This is a Fullstack Spring Boot application that provides a REST API for managing employee data. It features Role-Based Access Control (RBAC) to manage user permissions and JSON Web Token (JWT) authentication for secure access.
Frontend part of this application is deployed in a seperate repository, [Front End User Repository](https://github.com/pete98/user-management-system-frontend.git).

# Website URL
[um.pranavsailor.com](http://um.pranavsailor.com)

# Demo Accounts  
To explore admin and super admin functionality, use the following credentials:  

- **Admin**  
  - Email: `test@admin.com`  
  - Password: `admin123`  

- **Super Admin**  
  - Email: `super.admin@email.com'
  - Password: `123456`  


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
*   **Database**: AWS RDS MYSQL database 
*   **Maven:** Build tool.
*   **AWS EC2:** Used for deploying the backend server.
*   **Netlify** A platform for hosting the frontend website.
*   **React:** A JavaScript library for building user interfaces.

## Postman Collection

For testing the backend APIs, a Postman collection is available in the repository. You can import it directly into Postman:

File: User Management System.postman_collection.json

This collection contains all the API endpoints used in the project along with example requests and responses.



