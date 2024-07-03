![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) 
![Spring Boot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot)
![Angular](https://img.shields.io/badge/Angular-DD0031?style=for-the-badge&logo=angular&logoColor=white)
![Stack Overflow](https://img.shields.io/badge/-Stackoverflow-FE7A16?style=for-the-badge&logo=stack-overflow&logoColor=white)
![CSS](https://img.shields.io/badge/CSS-239120?&style=for-the-badge&logo=css3&logoColor=white)

## General Information
- Full-Stack Application for parsing Poker Hand History files (PokerStars platform) to Java objects and display cards on frontend
- The app shows the hands played by one player
- The main logic is stored in a PositionGenerator class - where the program counts all the current players positions like they were sitting by a real table

## Technologies Used
- Java - version 17
- Spring Boot - 3.2.5
- Angular - 17.3.0

## Usage
 - The application runs on Localhost
 - Backend (localhost: 8080): run HandHistoryReplayerSpringApplication.java
 - Frontend (localhost: 4200): cd frontend folder | npm i | ng serve --open
   (Node.js, Angular CLI needed)
   
 - The running app has:  
1 - A button to upload the Hand history file (an example file is stored in resources/templates folder)  
2 - A button to show the played hands and further details 

## Room for improvement
 - Now works only for a hardcoded user

##
![home.png](home.png)
![hand.png](hand.png)




