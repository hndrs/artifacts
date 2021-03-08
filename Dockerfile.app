FROM openjdk:15-alpine

VOLUME /tmp

COPY ["build/libs/*.jar","/app/application.jar"]

WORKDIR /app

CMD ["sh","-c","java -XX:MaxRAMPercentage=85 -jar -Dserver.port=$PORT application.jar"]
