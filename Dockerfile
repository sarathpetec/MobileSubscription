FROM adoptopenjdk/openjdk11:alpine-jre
WORKDIR /target
ARG JAR_FILE=target/mobile-subscription.jar
COPY ${JAR_FILE} mobile-subscription.jar
ENTRYPOINT ["java","-jar","mobile-subscription.jar"]