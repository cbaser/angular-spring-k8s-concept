FROM maven:3.6-jdk-11 as maven_build
WORKDIR /app

COPY pom.xml .
COPY src ./src

# build the app and download dependencies only when these are new (thanks to the cache)
RUN mvn clean package -DskipTests

# split the built app into multiple layers to improve layer rebuild
RUN mkdir -p target/docker-packaging && cd target/docker-packaging && jar -xf ../user-micro-server*.jar

########JRE run stage########
FROM openjdk:11.0-jre
WORKDIR /app

#copy built app layer by layer
ARG DOCKER_PACKAGING_DIR=/app/target/docker-packaging
COPY --from=maven_build ${DOCKER_PACKAGING_DIR}/BOOT-INF/lib /app/lib
COPY --from=maven_build ${DOCKER_PACKAGING_DIR}/BOOT-INF/classes /app/classes
COPY --from=maven_build ${DOCKER_PACKAGING_DIR}/META-INF /app/META-INF

#run the app
CMD java -cp .:classes:lib/* \
         -Djava.security.egd=file:/dev/./urandom \
         com.cbaser.usermicroserver.UserMicroServerApplication