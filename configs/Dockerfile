FROM openjdk:11.0-jdk-slim AS build

COPY *.gradle gradle.* gradlew /app/
COPY gradle /app/gradle

WORKDIR /app

RUN ./gradlew --version

COPY . .

RUN ./gradlew --no-daemon shadowJar --console plain

FROM openjdk:11.0-jre-slim

WORKDIR /app

EXPOSE 7000

COPY --from=build /app/cli/build/libs/cli-all.jar /app/cli.jar
ENTRYPOINT java -Dlogging=json -jar cli.jar
