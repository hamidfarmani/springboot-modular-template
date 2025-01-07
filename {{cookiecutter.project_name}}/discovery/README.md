# Discovery Service README

This module provides service discovery functionality using Eureka. It allows microservices to register and discover each other, enabling dynamic scaling and routing.

## Features
- Built with Spring Boot and Eureka Server.
- Enables service discovery for microservices.
- Provides a centralized registry for tracking running services.

## How to Run
1. Navigate to the discovery service directory:
   ```bash
   cd discovery
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
By default, Eureka runs on port `8761`. You can customize this in `application.yml` or using config-server's centralized configuration:

```yaml
server:
  port: 8761

eureka:
  client:
    register-with-eureka: false
    fetch-registry: false
  server:
    wait-time-in-ms-when-sync-empty: 0
```