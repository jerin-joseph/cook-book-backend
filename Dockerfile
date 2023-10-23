#FROM openjdk:17-oracle
#EXPOSE 8081
#VOLUME /tmp
#ADD build/libs/*.jar app.jar
#RUN ./gradlew build
#ENTRYPOINT ["java","-jar","/app.jar"]

#Build stage

FROM gradle:latest AS BUILD
WORKDIR /usr/app/
COPY . .
RUN gradle build -x test

# Package stage
FROM openjdk:17-oracle
ENV JAR_NAME=cook-book-0.0.1.jar
ENV APP_HOME=/usr/app
WORKDIR $APP_HOME
COPY --from=BUILD $APP_HOME .
EXPOSE 8080
ENTRYPOINT exec java -jar $APP_HOME/build/libs/$JAR_NAME