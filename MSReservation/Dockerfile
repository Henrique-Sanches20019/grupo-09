FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN chmod +x ./mvnw
RUN ./mvnw package -DskipTests

EXPOSE 8082

CMD ["java", "-jar", "target/MSReservation-0.0.1-SNAPSHOT.jar"]
