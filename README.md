# Game of three
Restful API game with two independent units – the players – communicating with each other using the ActiveMQ.

## Requirements

    Java
    Spring boot
    Maven
    Docker

## Instructions:

#### Clone

    git clone https://github.com/mubashirali/game-of-three.git


#### Build the project 
 
    mvn clean install


#### Run the project:
 
Start Apache ActiveMQ: 

    docker-compose up

Start player one
    
    java -jar target/game-of-three-0.0.1-SNAPSHOT.jar 

Start player Two
    
    java -jar target/game-of-three-0.0.1-SNAPSHOT.jar --spring.config.name=application_player2


#### POST Request:
Call the endpoint using Swagger UI or any API client.
    
    POST http://localhost:8080/v1/api/gameofthree/play  
    
    Request Body: {  "number": 56 }
    
    Response: 200

#### Swagger UI
    http://localhost:8080/swagger-ui.html

