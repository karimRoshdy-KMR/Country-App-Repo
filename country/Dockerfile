#FROM openjdk:8
#EXPOSE 8030
#ADD target/country-app.jar country-app.jar
#ENTRYPOINT ["java","-jar","/country-app.jar"]
FROM openjdk:8-jre
VOLUME ["/country-app"]
EXPOSE 8030
ADD target/country-app.jar country-app.jar
ENTRYPOINT ["java","-jar","/country-app.jar"]