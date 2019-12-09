FROM openjdk:latest

COPY target/helloworldkubernetes-0.0.1-SNAPSHOT.jar /usr/src/helloworldkubernetes-0.0.1-SNAPSHOT.jar

CMD java -jar /usr/src/helloworldkubernetes-0.0.1-SNAPSHOT.jar --spring.config.location=/deployments/config/helloworld.properties