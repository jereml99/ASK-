FROM maven:3.6.1-jdk-8-slim AS build
RUN mkdir -p /workspace
WORKDIR /workspace
COPY pom.xml /workspace
COPY src /workspace/src
RUN mvn -f pom.xml clean package

FROM openjdk:8
COPY --from=build /workspace/target/*.jar app.jar
# RUN groupadd -g 1000 basicuser && \
#   useradd -r -u 1000 -g basicuser basicuser
# USER basicuser
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]