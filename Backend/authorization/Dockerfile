FROM openjdk:8
EXPOSE 8080
ADD target/authorization-0.0.1-SNAPSHOT.jar authapp.jar
ENTRYPOINT ["java","-jar","/authapp.jar"]