# API Gateway README

This module acts as a gateway for routing and load balancing requests to backend services. It uses Spring Cloud Gateway for reactive request handling.

## Features
- Routes requests to backend services dynamically.
- Centralized API entry point.
- Supports load balancing and rate limiting.

## How to Run
1. Navigate to the API gateway directory:
   ```bash
   cd gateway
   ```
2. Build the service:
   ```bash
   mvn clean install
   ```
3. Run the service:
   ```bash
   mvn spring-boot:run
   ```

## Configuration
Routes are defined in `application.yml`. Example:

```yaml
spring:
  cloud:
    gateway:
      routes:
        - id: user-service
          uri: lb://USER-SERVICE
          predicates:
            - Path=/users/**
```