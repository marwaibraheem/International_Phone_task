#define base for docker
FROM openjdk:8
ADD target/service-task-0.0.1-SNAPSHOT.jar service-task.jar 
EXPOSE 8092
ENTRYPOINT ["java","-jar","/service-task.jar"]