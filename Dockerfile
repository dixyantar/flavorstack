# https://hub.docker.com/_/maven
FROM maven:3.6-adoptopenjdk-11 as builder


# Copy local code to the container image.
WORKDIR /app
COPY pom.xml .
COPY flavorstack/src ./src

# Build a release artifact.
RUN mvn package -DskipTests


#https://hub.docker.com/layers/adoptopenjdk/openjdk11/
FROM adoptopenjdk/openjdk11:jdk-11.0.7_10-alpine-slim


COPY --from=builder /app/target/flavorstack-*.jar /flavorstack.jar

# Run the web service on container startup.
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/flavorstack.jar"]


