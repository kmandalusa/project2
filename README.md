# project2: Magic Hotel Booking
Hotel Room Booking System


## Project Description

In this project:
Users can log in and look for hotels to check in to.

## Technologies Used

* Javalin - version 4.1.1
* Java - version 8
* Hibernate - version 5.6.0
* Maven - version 3.0
* HTML - version 5.0
* CSS - version 4.15
* JavaScript 
* Junit - version 4.12 
* Selenium  
* Cucumber  
* AWS RDS

## Features

List of features ready and TODOs for future development
* It has login page
* Wrong Login Leads to Error page
* Successful employee login takes to employee page 
* Employee can submit a new expense and view previous expenses and Logout
* Successful Manager login takes to manager page 
* Manager can view all employees submitted expenses and accept and deny
* Manager can view previous submitted form
* Manager can view statistics page and at end logout
To-do list:
* Can add reason for denial
* Better user interface
* Better error handling mechanism
* I can do more testing

## Getting Started


   
* git clone https://github.com/kmandalusa/project2.git
* cd project2
* Before running the project you have to set up database server
* It can use either Postgres or AWSPostgres RDS , according to use of database, hibernate.cfg.xml file needs to  be updated.
* Have to create a database name "revature"
* Once run the project Hybernate creats the tables.
* Before using the project Employee table must have the data for both employee and manager role


Open/Import the project in any IDE Eclipse/IntelliJ

Run the project as java application
In browser open http://localhost:7777
(include all environment setup steps)




**Cucumber Testing using Command Line**

Go to the project folder

Open project1 on Command Line

Run command

```
mvn clean test
```

Check the cucumber report under cucumber-test/target

https://www.baeldung.com/cucumber-rest-api-testing


**Selenium Testing on Command Line**

Go to the project folder

Open project1 on Command Line

Run command

```
selenium-side-runner -w 1 SelemiumTestProject1.side
```

https://www.selenium.dev/selenium-ide/docs/en/introduction/command-line-runner
