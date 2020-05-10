from adoptopenjdk/openjdk11:alpine-jre

WORKDIR /app
COPY target/sample-fi-0.0.1-SNAPSHOT.jar .

ENTRYPOINT ["java", "-Dserver.port=8083", "-jar", "sample-fi-0.0.1-SNAPSHOT.jar"]