#!/bin/sh
./gradlew bootJar
docker-compose build
docker-compose up