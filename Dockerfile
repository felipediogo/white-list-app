FROM openjdk:8-jre-alpine

COPY ./target/white-list-app-0.0.1-SNAPSHOT.jar white-list-app.jar
COPY ./wait-for-it.sh wait-for-it.sh

RUN chmod +x ./wait-for-it.sh

RUN /bin/sh -c "apk add --no-cache bash"

ENTRYPOINT ["bash", "./wait-for-it.sh", "mysql:3306", "--", "java", "-jar", "white-list-app.jar"]