FROM maven:3.9.9-amazoncorretto-23-alpine AS build

ADD pom.xml /

ADD src /src

RUN mvn --quiet clean package

FROM amazoncorretto:21-alpine

RUN apk update && apk add bash openssl

COPY --from=build /target/gids-hti-testsuite.jar /gids-hti-testsuite.jar

ENV TZ="Europe/Amsterdam"

ADD entrypoint.bash /

RUN chmod +x entrypoint.bash

EXPOSE 8080

ENTRYPOINT [ "/bin/bash", "entrypoint.bash" ]
