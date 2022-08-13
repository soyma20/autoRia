FROM openjdk:8

MAINTAINER Soyma20

RUN mkdir /app
WORKDIR /app

COPY wait-for-it.sh /
RUN chmod +x /wait-for-it.sh