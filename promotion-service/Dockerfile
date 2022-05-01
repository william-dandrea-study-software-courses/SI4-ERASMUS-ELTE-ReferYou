#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
RUN mkdir /service
COPY src /service/src
COPY mvnw /service
COPY pom.xml /service
WORKDIR /service
RUN mvn clean package -Dmaven.test.skip
# RUN /bin/sh

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /service /service
EXPOSE 8081
ENTRYPOINT ["java","-jar","/service/target/promotion-service-0.0.1-SNAPSHOT.jar"]
# RUN /bin/sh
