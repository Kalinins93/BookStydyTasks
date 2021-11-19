FROM ubuntu:22.04
RUN apt-get update && \
    mkdir -p /usr/share/man/man1 && \
    apt-get install -y apt-utils  &&\
    apt-get install -y openjdk-11-jre && \
    apt-get install -y ant && \
    apt-get clean

RUN apt-get update && \
    apt-get install ca-certificates-java && \
    apt-get clean && \
    update-ca-certificates -f \

RUN apt install -y maven

ENV JAVA_HOME /usr/lib/jvm/java-11-openjdk-amd64/
RUN export JAVA_HOME
##
RUN mkdir /usr/src/my_app_directory
WORKDIR /usr/src/my_app_directory

COPY  BookStydyTasks-1.0-SNAPSHOT.jar /usr/src/my_app_directory
COPY  /home/ilia/Documents/BookStydyTasks/src/main/resources/application.yml /usr/src/my_app_directory
ENTRYPOINT ["java", "-jar","BookStydyTasks-1.0-SNAPSHOT.jar", "--spring.config.location=file:///application.yml"]
EXPOSE 8081