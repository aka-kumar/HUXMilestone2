FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD target/netflixshow-0.0.1-SNAPSHOT.jar netflixshow-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/netflixshow-0.0.1-SNAPSHOT.jar"]