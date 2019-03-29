FROM openjdk:8u171-alpine3.7
RUN apk --no-cache add curl
#COPY target/micro-naut*.jar micro-naut.jar
COPY build/libs/micro-naut*.jar micro-naut.jar
CMD java ${JAVA_OPTS} -jar micro-naut.jar