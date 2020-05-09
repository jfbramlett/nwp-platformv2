from adoptopenjdk/openjdk11:alpine-jre

WORKDIR /app
COPY target/platform-0.0.1-SNAPSHOT.jar .

ENTRYPOINT ["java", "-jar", "platform-0.0.1-SNAPSHOT.jar"]