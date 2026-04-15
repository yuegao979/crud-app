FROM openjdk:8

EXPOSE 8081

COPY target/wipflash.jar /wipflash.jar

ENTRYPOINT ["java", "-jar", "/wipflash.jar"]
