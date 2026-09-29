# Controle de EPIs

A web application developed as my final course project at SENAI to manage Personal Protective Equipment (PPE).

## About the Project

The system was developed to help manage employees, equipment, inventory, and PPE loans and returns.

The project allowed me to apply my knowledge of Java, Spring Boot, database persistence, and web development.

## Features

- Employee registration and management
- User management
- PPE and equipment type registration
- Inventory management
- Equipment loans and returns
- Data persistence and validation

## Technologies

- Java 17
- Spring Boot 3
- Spring Web
- Spring Data JPA
- Hibernate
- MariaDB
- Thymeleaf
- Maven
- HTML, CSS, and Bootstrap

## Academic Project

Developed as a final course project for the Systems Development Technician program at SENAI.

## Requirements

To run this project locally, you need:

- Java Development Kit (JDK) 17
- MariaDB
- Git

## Database Configuration

1. Install and start MariaDB.
2. Create a database named `epis`.
3. Configure your database credentials in `src/main/resources/application.properties`.

Update the following properties with your local MariaDB username and password:

```properties
spring.datasource.url=jdbc:mariadb://localhost:3306/epis
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
```

Do not commit real database passwords or credentials to the repository.

## Running the Application

Clone the repository:

```bash
git clone https://github.com/Eduardo-Silva-Mateus/Controle-de-Epis.git
```

Open the project directory containing the Maven wrapper.

On Windows, run:

```powershell
.mvnw.cmd spring-boot:run
```

The application will start using the local database configuration.

## Author

**Eduardo Mateus da Silva**

- GitHub: [Eduardo-Silva-Mateus](https://github.com/Eduardo-Silva-Mateus)
- LinkedIn: [Eduardo Mateus da Silva](https://www.linkedin.com/in/eduardomateussilva)
