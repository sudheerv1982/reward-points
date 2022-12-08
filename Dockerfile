FROM openjdk:8u232-jdk-stretch

WORKDIR /app
COPY target/reward-points*.jar /app/reward-points.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar","/app/reward-points.jar"]