FROM openjdk:11.0.16 as builder

WORKDIR /app/cibernos

COPY ./pom.xml /app
COPY ./cibernos/.mvn ./.mvn
COPY ./cibernos/mvnw .
COPY ./cibernos/pom.xml .

RUN ./mvnw clean package -Dmaven.main.skip -Dspring-boot.repackage.skip
#RUN ./mvnw dependency:go-offline

COPY ./cibernos/src ./src

RUN ./mvnw clean package

FROM openjdk:11.0.16

WORKDIR /app
RUN mkdir ./logs
COPY --from=builder /app/cibernos/target/cibernos-0.0.1-SNAPSHOT.jar .

EXPOSE 5000
ENTRYPOINT ["java", "-jar", "cibernos-0.0.1-SNAPSHOT.jar"]
