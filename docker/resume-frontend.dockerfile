#
# @author devstudy
# @see http://devstudy.net
#
# docker build -t devstudy/resume-frontend:1.0 -f docker/resume-frontend.dockerfile .
#
FROM nginx:1.17.2-alpine

ADD docker/nginx/nginx.conf      /etc/nginx/nginx.conf
