FROM openjdk:8-jdk-windowsservercore
VOLUME /tmp
COPY target/services_store-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]