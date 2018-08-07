FROM openjdk:8-jre-alpine

ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    NGCP_SLEEP=0 \
    JAVA_OPTS=""

# Add a ngcpservice user to run our application so that it doesn't need to run as root
RUN adduser -D -s /bin/sh ngcpservice
WORKDIR /home/ngcpservice

ADD entrypoint.sh entrypoint.sh
RUN chmod 755 entrypoint.sh && chown ngcpservice:ngcpservice entrypoint.sh
USER ngcpservice

ARG JAR_FILE
ADD ${JAR_FILE} app.jar

ENTRYPOINT ["./entrypoint.sh"]
