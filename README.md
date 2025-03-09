# VetClinicSystem

VetClinicSystem is a **Spring Boot**-based application designed to manage veterinary clinic operations, including pet management, doctor scheduling, clinic visits, and owners' records.

## Features

- **Pet Management**: Add, update, delete, and retrieve pet information.
- **Doctor Management**: Manage veterinary doctors and their schedules.
- **Clinic Management**: Keep track of clinic locations and services.
- **Owner Records**: Maintain records of pet owners.
- **Visit Scheduling**: Schedule and track pet visits with doctors.
- **File Upload**: Upload pet images using multipart form data.
- **API Documentation**: Integrated **Swagger** for API exploration.

## Requirements

- **Java 17+**
- **Spring Boot 3+**
- **MySQL (or another relational database)**
- **Maven**
- **Postman** (for API testing)

## Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/yourusername/VetClinicSystem.git
   cd VetClinicSystem
   ```

2. **Configure the database in `application.properties`:**

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/vetclinic
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   ```

3. **Build and run the application:**

   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

## API Documentation (Swagger)

Once the application is running, access Swagger UI for API documentation:

- **Swagger UI:** [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- **OpenAPI JSON:** [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

## Testing with Postman

1. **Open Postman.**
2. **Import the Postman collection** from the `postman_collection` folder.
3. **Update environment variables** if necessary.
4. **Use the predefined requests** to interact with the API.

---

💡 *For any issues or contributions, feel free to submit a pull request or report bugs in the repository!*
