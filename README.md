![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) 
![Spring Boot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot)
![Angular](https://img.shields.io/badge/Angular-DD0031?style=for-the-badge&logo=angular&logoColor=white)
![Stack Overflow](https://img.shields.io/badge/-Stackoverflow-FE7A16?style=for-the-badge&logo=stack-overflow&logoColor=white)
![CSS](https://img.shields.io/badge/CSS-239120?&style=for-the-badge&logo=css3&logoColor=white)

## General Information
- Full-Stack Application for parsing Poker Hands from a specific document to Java objects and display the values 
- The app shows the results of one player, but stores all the results of the whole hand as well
- The main logic is stored in a PositionGenerator class - where the program counts all the current players positions like they were sitting by a real table

## Technologies Used
- Java - version 17
- Spring Boot - 3.2.5
- Angular - 17.3.0

## Usage
 - The application runs on Localhost
 - Backend (localhost: 8080): run HandHistoryReplayerSpringApplication.java
 - Frontend (localhost: 4200): cd frontend folder | npm i | ng s --open
   (Node.js, Angular CLI needed)
 - Running app:  
1 - The user could upload the file (stored in resources/templates folder for trial purposes)  
2 - Click to the Hand button  
3 - The app shows the details of the Poker Hands  

## Room for improvement
 - Now works only for a hardcoded user

##
![home.png](home.png)
![hand.png](hand.png)




