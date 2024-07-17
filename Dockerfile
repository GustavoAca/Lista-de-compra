FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY target/listadecompra-0.0.3.jar /app/listadecompra-0.0.3.jar

ENV JAVA_OPTS="-Xmx256m -Xms128m"

RUN adduser -D listadecompra
USER listadecompra

CMD ["java", "-jar", "listadecompra-0.0.3.jar", "--spring.profiles.active=prod", ">", "/app/app.log"]

RUN rm -rf /var/cache/apk/*

EXPOSE 8080