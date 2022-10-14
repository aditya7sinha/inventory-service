FROM adoptopenjdk/openjdk15:ubi
#ENV APP_HOME=/usr/app/
#WORKDIR $APP_HOME
#COPY build/libs/*.jar app.jar
ADD target/inventoryservice-api-docker.jar app.jar
ENTRYPOINT ["java", "-jar","app.jar"]
EXPOSE 8080