## Airbnb_Database
The project aims to create an Airbnb-like database using Spring Boot framework and JWT security. It involves developing a web application that allows users to list and book properties for short-term rentals. The project will implement user authentication and authorization using JSON Web Tokens (JWT) for secure access to the application.
Using Spring Boot, the application will provide a RESTful API to handle CRUD operations for entities such as users, properties, and bookings. The database will be set up using MySQL, with the necessary configuration details specified in the application.properties file.

Entities such as User, Listing, and Booking will be defined as Java classes with appropriate JPA annotations to establish relationships and map them to the corresponding database tables. The project will leverage Spring Data JPA for database operations, making it easier to interact with the database through repositories and queries.

JWT security will be implemented to ensure that only authenticated and authorized users can access certain resources. Upon successful authentication, a JWT token will be generated and returned to the client, which will be used to authorize subsequent API requests. The token will be validated on the server-side to ensure the authenticity and permissions of the user.

Overall, this project combines the power of Spring Boot, MySQL, and JWT security to create a secure and efficient Airbnb-like database that allows users to manage and book properties seamlessly.


### Technical Stacks

- Spring Boot 
- Spring Framework
- Spring Data JPA 
- MySQL 
- Hibernate
- Java
- Swagger UI
- Postman
- Spring Security


### Modules
-  Authentication Module
-  Admin Module
-  Users Module
-  Listing Module
-  Location Module
-  Amenities Module
-  Booking Module
-  Review Module


### ER Diagram

### Installation & Run
- Before running the API server, you have to update the database configuration inside the application.properties file
- Update the port number, username and password as per your local database configuration
````
    server.port=8888

    spring.datasource.url=jdbc:mysql://localhost:3306/airbnb;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=*****
    spring.datasource.password=******
 
 ````
    
 ## API Root Endpoint

`https://localhost:8888/index.html`

`http://localhost:8888/swagger-ui.html`
    



