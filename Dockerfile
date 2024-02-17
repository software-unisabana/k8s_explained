FROM amazoncorretto:21.0.1
COPY build/libs/examplek8s-*.jar /app/example.jar
CMD ["java", "-jar", "/app/example.jar"]