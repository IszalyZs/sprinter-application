FROM maven:3.8.1-jdk-11-slim
WORKDIR /app
COPY pom.xml ./
RUN mvn dependency:go-offline
COPY src /app/src
RUN mvn clean package -DskipTests
ADD https://github.com/ufoscout/docker-compose-wait/releases/download/2.9.0/wait /app/wait
RUN chmod +x /app/wait
CMD /app/wait && "java" "-jar" "./target/super-sprinter-3000-java-IszalyZs-1.0-SNAPSHOT.jar"


