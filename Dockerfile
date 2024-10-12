# Use JDK 23 image
FROM eclipse-temurin:23-jdk-alpine

# Add a volume to store the logs (optional)
VOLUME /tmp

# Copy the jar file into the container
ARG JAR_FILE=build/libs/WishlistBackendDB-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar


# Set environment variables for the database connection
ENV db_url="jdbc:mysql://c584md9egjnm02sk.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/v4hbf09hn2uv0gfc?useSSL=false&serverTimezone=UTC"
ENV db_username="f2vju459mp652zxw"
ENV db_password="imzbufv1tqr959eg"

EXPOSE $PORT


# Run the jar file when the container starts, use Heroku's dynamically provided port
CMD java -jar /app.jar --server.port=$PORT