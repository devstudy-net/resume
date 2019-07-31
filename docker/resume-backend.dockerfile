#
# @author devstudy
# @see http://devstudy.net
#
# docker build -t devstudy/resume-backend:1.0 -f docker/resume-backend.dockerfile .
#
FROM devstudy/tomcat:8

RUN rm -rf /opt/tomcat/ROOT && \
    apk add --no-cache bash libjpeg-turbo-utils
ADD target/ROOT/ /opt/tomcat/webapps/ROOT/
ADD docker/app/application.properties /opt/tomcat/webapps/ROOT/WEB-INF/classes/properties/
ADD docker/app/elasticsearch.properties /opt/tomcat/webapps/ROOT/WEB-INF/classes/properties/
ADD docker/app/mongo.properties /opt/tomcat/webapps/ROOT/WEB-INF/classes/properties/
ADD docker/app/email.properties /opt/tomcat/webapps/ROOT/WEB-INF/classes/properties/
ADD docker/app/logback.xml /opt/tomcat/webapps/ROOT/WEB-INF/classes/
ADD docker/app/wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh
