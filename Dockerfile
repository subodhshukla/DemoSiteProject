# Use an official OpenJDK runtime as a parent image
FROM openjdk:21-slim

# Set the working directory in the container
WORKDIR /app

# Install wget and unzip
RUN apt-get update && \
    apt-get install -y wget unzip && \
    rm -rf /var/lib/apt/lists/*

# Download and install Gradle 8.3
RUN wget https://services.gradle.org/distributions/gradle-8.3-bin.zip && \
    unzip gradle-8.3-bin.zip && \
    mv gradle-8.3 /opt/gradle && \
    ln -s /opt/gradle/bin/gradle /usr/bin/gradle && \
    rm gradle-8.3-bin.zip

# Copy your application code and the gradlew file
COPY . ./

# Ensure gradlew is executable
RUN chmod +x gradlew && ls -l gradlew

# Build the application
RUN ./gradlew build --no-daemon -x test

# Optionally, you can still run tests if needed after building
RUN ./gradlew test

RUN cp -r build/reports/tests/test /app/test-reports

# Command to run TestNG with the TestNG XML
CMD ["java", "-cp", "app.jar:resources/*", "org.testng.TestNG", "resources/testng.xml"]