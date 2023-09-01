FROM openjdk
MAINTAINER Piotr Minkowski <piotr.minkowski@gmail.com>
ADD target/BookService-0.0.1-SNAPSHOT.jar book-service.jar
ENTRYPOINT ["java", "-jar", "/book-service.jar"]
EXPOSE 8081