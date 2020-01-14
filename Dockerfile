####
# This Dockerfile is used in order to build a container that runs the Quarkus application in JVM mode
#
# Before building the docker image run:
#
# mvn package
#
# Then, build the image with:
#
# docker build -f src/main/docker/Dockerfile.jvm -t quarkus/reverse-words-jvm .
#
# Then run the container using:
#
# docker run -i --rm -p 8080:8080 quarkus/reverse-words-jvm
#
###
# FROM fabric8/java-alpine-openjdk8-jre
FROM fabric8/java-jboss-openjdk8-jdk
# FROM 8-alpine
ENV JAVA_OPTIONS="-Dquarkus.http.host=0.0.0.0 -Djava.util.logging.manager=org.jboss.logmanager.LogManager"
COPY target/lib/* /deployments/lib/
COPY target/*-runner.jar /deployments/app.jar
ENTRYPOINT [ "/deployments/run-java.sh" ]