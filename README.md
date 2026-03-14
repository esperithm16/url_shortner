# Scalable URL Redirect Service

![Demo](https://raw.githubusercontent.com/esperithm16/url_shortner/main/ram.gif)

This project is a backend service that generates short URLs and redirects users to the original link.  
It is built using Spring Boot with PostgreSQL for persistent storage and deployed on an AWS EC2 server.

---

## Tech Stack

- Java  
- Spring Boot  
- Spring Data JPA  
- PostgreSQL  
- Gradle  
- AWS EC2  

---

## API Endpoints

### Create Short URL

Endpoint  
POST /api/shorten  

Request Body

{
"url": "https://google.com"
}

Response  
Returns a generated short code

Example

Td8eAZ

---

### Redirect to Original URL

Endpoint  
GET /{shortCode}

Example

GET /Td8eAZ

When this endpoint is accessed, the service looks up the original URL in the database and redirects the user to that link.

---

## Example Workflow

1. Send a request to create a short URL

POST http://<server-ip>:8080/api/shorten

2. API generates and returns a short code

Example

Td8eAZ

3. Open the generated short URL in the browser

http://<server-ip>:8080/Td8eAZ

4. The service redirects the user to the original URL.

---

## Running the Project Locally

Clone the repository

git clone https://github.com/esperithm16/url_shortner.git

Navigate to the project folder

cd url_shortner

Run the application

./gradlew bootRun

The application will start on

http://localhost:8080

---

## Deployment

The application is deployed on an AWS EC2 instance.

Build the application

./gradlew build

Transfer the generated JAR to the server

scp demo2-0.0.1-SNAPSHOT.jar ubuntu@<ec2-ip>:~

Run the application on the server

nohup java -jar demo2-0.0.1-SNAPSHOT.jar &

---

## Author

Rajat
