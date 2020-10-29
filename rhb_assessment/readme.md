Build Restful CRUD API for a simple CRUD Application using Spring Boot, Mysql and Hibernate.

Requirements
-----------------
1. Java - 1.8.x
2. Spring - 2.x.x
3. Mysql - 5.x.x
4. Maven - 3.x.x


Steps to start testing
----------------------

1. Clone the applications from provided link.
git clone 

2. Create Mysql databese named 'movie'
create database movie

3. Set up mysql username and password as per your installation in application.properties
open `src/main/resources/application.properties`
change `spring.datasource.username` and `spring.datasource.password` field

4. Build and run the application using maven
mvn package
mvn clean install
java -jar target/movie-1.0.0.jar

The application will start running at <http://localhost:8080/movie>.

5. Rest APIs can be test using postman or any rest client existing.
The app defines following CRUD APIs.

To Create new data
POST movie/api/movies

To Retrieve All data in table
GET movie/api/movies

To Retrieve by ID
GET movie/api/movies/{movieId}
    
To Update data
PUT movie/api/movies/{movieId}
    
To Delete data by ID
DELETE movie/api/movies/{movieId}

