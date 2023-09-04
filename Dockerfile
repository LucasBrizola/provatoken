FROM openjdk:19-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} provatoken-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/provatoken-0.0.1-SNAPSHOT.jar"]