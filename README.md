# Scalable URL Redirect Service

![Demo](https://raw.githubusercontent.com/esperithm16/url_shortner/main/ram.gif)

This project is a backend service that generates short URLs and redirects users to the original link.  
It is built using Spring Boot with PostgreSQL for persistent storage and deployed on an AWS EC2 server.

## Tech Stack

- Java  
- Spring Boot   
- PostgreSQL  
- Gradle   

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
Example-Td8eAZ

### Redirect to Original URL
Endpoint  
GET /{shortCode}
Example -GET /Td8eAZ

When this endpoint is accessed, the service looks up the original URL in the database and redirects the user to that link.
