FROM ubuntu
RUN apt-get update && apt-get install openjdk-17-jdk curl vim -y
WORKDIR /opt
ADD target/product-management-*.jar product-management.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/opt/product-management.jar"]

