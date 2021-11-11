FROM openjdk:8-jdk-alpine
EXPOSE 8086
ADD /target/Timesheet-2.0.war Timesheet-2.0.jar
ENTRYPOINT ["java","-jar","Timesheet-2.0.war"]