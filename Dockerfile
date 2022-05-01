FROM openjdk:19-alpine

COPY . ./

WORKDIR /app

CMD java -jar mytodo-1.0-SNAPSHOT.jar
