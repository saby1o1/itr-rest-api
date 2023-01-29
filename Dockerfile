FROM openjdk:8
EXPOSE 8080
ADD target/rest-api-test.jar rest-api-test.jar
ENDPOINT ["java","-jar","/rest-api-test.jar"]
