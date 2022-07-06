FROM openjdk:18

COPY build/libs/GifAndRate-0.0.1-SNAPSHOT.jar /GifAndRate.jar

ENTRYPOINT ["java", "-jar", "/GifAndRate.jar"]