FROM openjdk:8-jdk-alpine
copy ./target/netflixshow-0.0.1-SNAPSHOT.jar netflixshow-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","netflixshow-0.0.1-SNAPSHOT.jar"]