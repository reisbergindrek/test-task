# we are extending everything from tomcat:8.0 image ...
FROM tomcat:9.0
MAINTAINER indrek

# COPY path-to-your-application-war path-to-webapps-in-docker-tomcat
COPY target/indrek-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war
CMD ["catalina.sh","run"]