MOSIP ID Authentication – Extended Endpoints

This module is part of the MOSIP ID Authentication
microservice suite.
The authentication-service component provides REST APIs for performing authentication of individuals.

This extension introduces two new REST endpoints for improved auditing and verification support.

📌 New Endpoints
1. Audit Logging API

Path:

POST /api/v1/audit/log


Description:
Stores an audit event (e.g., login attempt, verification request) in the system for traceability.

Request Body (JSON):

{
"eventType": "LOGIN",
"description": "User attempted login",
"userId": "12345"
}


Response (200 OK):

{
"status": "success",
"message": "Audit event logged successfully"
}

2. Verification API

Path:

POST /api/v1/auth/verify


Description:
Verifies user credentials or identity attributes. Intended for internal modules that require a quick verification service.

Request Body (JSON):

{
"userId": "12345",
"credential": "******"
}


Response (200 OK):

{
"verified": true,
"timestamp": "2025-10-05T15:30:00Z"
}

🛠️ How to Run Locally

Clone the repository:

git clone https://github.com/mosip/id-authentication.git
cd id-authentication/authentication-service


Build the project (requires JDK 11 and Maven 3.6+):

mvn clean install


Start the service:

mvn spring-boot:run


Access APIs at:

http://localhost:8080/api/v1/

✅ Testing

Unit tests are written using JUnit 5, Spring Boot Test, and Mockito.

Run tests:

mvn test

📂 Project Structure
authentication-service
└── src
└── main
└── java/io/mosip/authentication/service
├── controller        # REST controllers
├── service           # Business logic
├── dto               # Request/Response DTOs
├── repository        # JPA Repositories
└── ...

📖 Documentation

MOSIP Authentication Overview

Swagger/OpenAPI (if enabled): http://localhost:8080/swagger-ui.html