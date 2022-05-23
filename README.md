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

### Test Process 
-  Create a station  
POST http://127.0.0.1:1212/stations
-  Create a motor cycle  
POST http://127.0.0.1:1212/motor-cycles
-  Create a battery inventory  
http://127.0.0.1:1212/batteries
-  Create a driver  
http://127.0.0.1:1212/drivers
-  Assign a battery to a motor cycle  
http://127.0.0.1:1212/batteries/6/allocate/5
-  Assign a driver to a motor cycle  
http://127.0.0.1:1212/motor-cycles/5
-  Create a cost setup  
http://127.0.0.1:1212/cost-setups
-  Do a battery swap  
http://127.0.0.1:1212/batteries/9
-  Get swaps logs  
http://127.0.0.1:1212/swaps  
-  Know the revenue generated revenue  
-  Get total consumption by a driver  
http://127.0.0.1:1212/drivers/2/consumption  
-  Get total transactions  
http://127.0.0.1:1212/transactions  
-  Get motor cycles in motion  
http://127.0.0.1:1212/motor-cycles  

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
-  Git for source control
-  OpenAPI 3.0(Swagger) for endpoints documentation

## Contact
You can reach me on [this email](gichurepaul@gmail.com).

