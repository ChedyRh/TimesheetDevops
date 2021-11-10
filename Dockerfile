FROM openjdk:8-jdk-alpine
EXPOSE 8083
ADD /target/Timesheet-0.0.4.jar Timesheet.jar
ENTRYPOINT ["java","-jar","Timesheet.jar"] 