# Spring Boot, MySQL, JPA, Hibernate Rest API Tutorial

Build Restful CRUD API for Iapl Robot application using Spring Boot, Mysql, JPA and Hibernate.

## Requirements

1. Java - 1.8.x

2. Maven - 3.x.x

3. Mysql - 5.x.x

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/sesdave/iapl-robot.git
```

**2. Create Mysql database**
```bash
create database iaplsurvivor
```

**3. Change mysql username and password as per your installation**

+ open `src/main/resources/application.properties`

+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation

**4. Build and run the app using maven**

```bash
mvn package
java -jar target/easy-notes-1.0.0.jar
```

Alternatively, you can run the app without packaging it using -

```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:8080>.

## Explore Rest APIs

The app defines following CRUD APIs.

    GET /api/notes
    
    POST /api/add_survivor
    
    GET /api/percentage-infected
    
    PUT /api/uninfected-survivors
    
    DELETE /api/robots

You can test them using postman or any other rest client.

## Postman Document

document is published on postman and url is -

<https://www.callicoder.com/spring-boot-rest-api-tutorial-with-mysql-jpa-hibernate/>
