# Use the official Gradle image as the base image
FROM gradle:8.3-jdk21 AS build

# Set the working directory
WORKDIR /app

# Copy Gradle files
COPY build.gradle settings.gradle ./
COPY gradle ./gradle

# Copy the source code
COPY src ./src

# Build the project (this will download dependencies)
RUN gradle clean build

# Use a lightweight JRE for running the tests
FROM openjdk:21-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the built artifacts from the build stage
COPY --from=build /app/build/libs/*.jar app.jar

# Copy the resources (TestNG XML, properties, Excel file) to the appropriate location
COPY --from=build /app/src/test/resources /app/resources

# Command to run TestNG with the TestNG XML
CMD ["java", "-cp", "app.jar:resources/*", "org.testng.TestNG", "resources/testng.xml"]