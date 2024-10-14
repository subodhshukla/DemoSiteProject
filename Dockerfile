# Use an official OpenJDK runtime as a parent image
FROM openjdk:21-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Gradle build files
COPY build.gradle settings.gradle ./
COPY gradle gradle

# Copy your source code into the container
COPY src src

# Copy the testng.xml configuration file
COPY testng.xml ./

# Run Gradle to build the application
RUN gradlew build

# Set the command to run your tests
CMD ["java", "-cp", "build/classes/java/test:build/libs/*", "org.testng.TestNG", "testng.xml"]