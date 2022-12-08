# Charter Reward points
This projects is created as an API end point to get rewards points of a customer by monthly and in total

To run application from command prompt/terminal use below command from the project downloaded directory

mvn spring-boot:run

**Configuration data amount vs points**

Currently this configuration is with in code base, which can be moved to database so that config can be read dynamically and applied.

|***Amount***|***Points***|
|:-----|:-----|
|50|1|
|100|1|

**Customer Transaction configuration**

|***Customer ID***|***Customer Name***|***Transaction Date***|***Transaction Amount***|
|:-----|:-----|:-----|:-----|
|1|Joe|10-10-2022|123|
|1|Joe|10-26-2022|52|
|1|Joe|11-10-2022|35|
|1|Joe|11-14-2022|234|
|1|Joe|12-04-2022|74|
|2|Smith|10-10-2022|74|
|2|Smith|11-11-2022|234|
|2|Smith|12-01-2022|78|
|2|Smith|12-03-2022|123|

**API Documentation**

[API Documentation](http://localhost:8080/swagger-ui-custom.html) 

**Health end-point**

[Health end-point](http://localhost:8080/actuator/health)

**Security**

We cannot leave APIs without authentication, so we have security implemented with basic auth. All API end points have authentication on except health and swagger documentation.
You can fine credentials in properties file. But in real production we will push them to a secret place(like parameter store/consul) and pull dynamically to the application.

**Unit test cases**

We have one test class(RewardPointsApplicationTests.java) which need to run as JUNIT test class. 

**Docker Commands**

Go to the project downloaded directory and run start and stop command for starting and stopping the application.

For Windows

1) start.bat --> start the application
2) stop.bat --> stop the application

For Mac

1) ./start.sh --> start the application
2) ./stop.sh --> stop the application

To start the application just run start.* from terminal/command prompt. Which will internally call the following
1) mvn clean install -DskipTests --> Build the project
2) docker-compose down --> Bring down any old container(s) already running
3) docker-compose build --> Builds database and runs Dockerfile of the application
4) docker-compose up --> Brings the application and database to running mode

With one step application will be up, running and ready for use.

To stop the application just run stop.* from terminal/command prompt. Which will internally call the following
1) docker-compose down --> Bring down any old container already running


