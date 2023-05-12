#FROM maven:3-openjdk-17-slim AS build
#WORKDIR /app
#COPY . ./project
#RUN mvn -f /app/project/pom.xml clean package

##
#FROM openjdk:17-jdk-alpine AS run
#EXPOSE 8080
#ENV MESG=kareem
#WORKDIR /usr/local/lib
#COPY --from=build  /app/project/target/*.jar app.jar
#ENTRYPOINT ["java" , "-jar" ,"app.jar"]

#FROM openjdk:17-jdk-alpine AS run
#EXPOSE 8080
#ENV MESG=kareem
#WORKDIR /usr/local/lib
#COPY ./target/*.jar  app.jar
#ENTRYPOINT ["java" , "-jar" ,"app.jar"]

FROM mongo:latest
EXPOSE 27017
VOLUME "/data/db"
