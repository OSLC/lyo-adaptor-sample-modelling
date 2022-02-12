# README

## Getting started

Run the adaptor as a regular web application:

    mvn clean jetty:run-war

Alternatively, with Tomcat via Maven Cargo:

    mvn clean package cargo:run

You can then explore the server starting with its [front page on localhost:8083](http://localhost:8083/adaptor-rm/) where you can navigate through its HTML pages, or access its Swagger interface. 
