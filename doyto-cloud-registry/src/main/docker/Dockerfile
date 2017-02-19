wFROM openjdk:8u111-jre-alpine
ADD doyto-cloud-registry-1.0.0.jar app.jar
VOLUME /tmp
VOLUME /target
RUN sh -c 'touch /app.jar'
EXPOSE 8761
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
