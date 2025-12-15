# Build stage usando JDK e Maven Wrapper (mvnw) presente no projeto
FROM eclipse-temurin:17-jdk AS build
WORKDIR /app

# copiar arquivos e garantir permissão do wrapper
COPY .mvn .mvn
COPY mvnw mvnw
COPY pom.xml pom.xml
COPY src src
RUN chmod +x ./mvnw && ./mvnw -B -f pom.xml clean package -DskipTests

# Run stage
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENV JAVA_OPTS=""
ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar /app/app.jar"]