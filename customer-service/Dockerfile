FROM java:8

EXPOSE 9001

ADD target/customer-service.jar customer-service.jar

ENTRYPOINT ["java","-jar","customer-service.jar"]