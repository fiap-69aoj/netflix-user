FROM openjdk:8-jdk-alpine

LABEL source="https://github.com/fiap-69aoj/netflix-user" \
      maintainer="flavioso16@gmail.com"

ADD ./targer/user-0.0.1-SNAPSHOT.jar user.jar

EXPOSE 8090

ENTRYPOINT ["java","-jar", "-Dspring.profiles.active=prod", "/user.jar"]