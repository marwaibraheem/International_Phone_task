#define base for docker
FROM openjdk:8-jdk-alpine
LABEL maintainer="task.net"
ADD target/service-task-0.0.1-SNAPSHOT.jar service-task.jar 
ENTRYPOINT ["java","-jar","/service-task.jar"]