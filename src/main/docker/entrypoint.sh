#!/bin/sh

echo "The application will start in ${NGCP_SLEEP}s..." && sleep ${NGCP_SLEEP}
exec java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar "${HOME}/app.jar" "$@"
