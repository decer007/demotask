FROM openjdk:14-alpine
COPY build/libs/demotask-*-all.jar demotask.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "demotask.jar"]