FROM java:8-jre
VOLUME /tmp

COPY ./build/libs/cloud-register-center-0.0.1-SNAPSHOT.jar cloud-register-center.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=peer1","-jar","cloud-register-center.jar"]

EXPOSE 8400