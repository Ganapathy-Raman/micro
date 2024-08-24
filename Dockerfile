FROM openjdk:18
WORKDIR /app
COPY ./target/OrganDonationManagementSystem-0.0.1-SNAPSHOT.jar /app
EXPOSE 1225
CMD ["java", "-jar", "OrganDonationManagementSystem-0.0.1-SNAPSHOT.jar"]
