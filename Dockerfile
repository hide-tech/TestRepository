FROM alpine:3.13

RUN apk add openjdk11

COPY target/tests-0.0.1.jar /app.jar

ENTRYPOINT ["java","-jar","/app.jar"]