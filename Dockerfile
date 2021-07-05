FROM openjdk:8
ADD target/mediscreen_gui-0.0.1-SNAPSHOT.jar mediscreen_gui-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar", "/mediscreen_gui-0.0.1-SNAPSHOT.jar"]
