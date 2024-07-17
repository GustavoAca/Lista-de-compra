FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY target/*.jar /app/app.jar

ENV JAVA_OPTS="-Xmx256m -Xms128m"

RUN adduser -D listadecompra
USER listadecompra

CMD ["sh", "-c", "java $JAVA_OPTS -jar /app/app.jar --spring.profiles.active=prod > /app/app.log 2>&1"]

RUN rm -rf /var/cache/apk/*

EXPOSE 8080
