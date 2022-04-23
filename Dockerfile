FROM adoptopenjdk:11-jre-hotspot

ADD target/tests-0.0.1.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]