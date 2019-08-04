# Build:
# docker build -t devstudy/resume-backend:1.0 -f docker/resume-backend.dockerfile .
#
FROM tomcat:8

MAINTAINER devstudy.net

ARG TOMCAT_ROOT=/usr/local/tomcat

RUN rm -rf ${TOMCAT_ROOT}/ROOT && \
    apt-get update -y && apt-get install libjpeg-progs -y && rm -rf /var/lib/apt/lists/*

ADD target/ROOT/ ${TOMCAT_ROOT}/webapps/ROOT/
ADD docker/app/application.properties ${TOMCAT_ROOT}/webapps/ROOT/WEB-INF/classes/properties/
ADD docker/app/elasticsearch.properties ${TOMCAT_ROOT}/webapps/ROOT/WEB-INF/classes/properties/
ADD docker/app/mongo.properties ${TOMCAT_ROOT}/webapps/ROOT/WEB-INF/classes/properties/
ADD docker/app/email.properties ${TOMCAT_ROOT}/webapps/ROOT/WEB-INF/classes/properties/
ADD docker/app/logback.xml ${TOMCAT_ROOT}/webapps/ROOT/WEB-INF/classes/
ADD docker/app/wait-for-service-up.sh /wait-for-service-up.sh
RUN chmod +x /wait-for-service-up.sh
