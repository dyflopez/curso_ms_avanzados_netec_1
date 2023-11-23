#imagen base
FROM openjdk:11-jdk-slim
#Donde se va copiar el JAr
#Creacion de un espacio de traabajo
WORKDIR /app
RUN mkdir ./logs

COPY target/hotel-ms-0.0.1-SNAPSHOT.jar .

ENV PORT 9090

EXPOSE $PORT

ENTRYPOINT ["java","-jar","hotel-ms-0.0.1-SNAPSHOT.jar"]
