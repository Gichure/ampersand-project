# Ampersand Software Engineer Project

A system to track the assets in motion, battery swap and telematics onboard. This is a RESTful services based project. 

*No authentication is required to test*

## Setup
1.  Ensure you have MySQL 5.7+ installed.  
2.  Ensure you have Maven 3.0+ installed and setup.  
3.  Ensure you have Git 3.0+ setup.  
4.  Ensure you have JDK 1.8+ installed  

## How to Test
1.  Clone this repository.
2.  cd to the project folder(ampersand)  
  
### Running the Application
1.  While ampersand folder, run the command mvn clean spring-boot:run  
2.  Access the APIs on [http://127.0.0.1:1212/swagger-ui/index.html](link). This gives you a list of APIs  

### Sample Tests
-  Create a station
-  Create a motor cycle
-  Create a battery inventory
-  Create a driver
-  Assign a battery to a motor cycle
-  Assign a driver to a motor cycle
-  Create a cost setup
-  Do a battery swap
-  Get swaps logs
-  Know the revenue generated revenue
-  Get total covered distance
-  Get total covered distance by a driver/cycle
-  Get motor cycles in motion

### Running the Static Analysis
1.  While ampersand folder, run the command mvn clean pmd:pmd  
2.  Access the report from /target/site/pmd.html

### Generating Javadoc
1.  While ampersand folder, run the command mvn clean install  
2.  Access the report from /doc/index.html

### Generating Jar File, UML Diagram and Build information
1.  While ampersand folder, run the command mvn clean package  
2.  Access the jar from /target/ampersand-1.0.0.jar
3.  Access the build information from /target/classes/git.properties
4.  Access the UML diagram from /target/Ampersand Software Engineer Project.urm.puml

## Technologies Used
-  Spring Boot (v 2.5.5) Framework - Web, JPA
-  Maven for Dependencies management and Build
-  MySQL for database management
-  Javadoc for Java code documentation
-  PMD for Static Analysis
-  Flyway for database migrations and versioning
-  Git for source control
-  OpenAPI 3.0(Swagger) for endpoints documentation

## Contact
You can reach me on [gichurepaul@gmail.com](this email).

