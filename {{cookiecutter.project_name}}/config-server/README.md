# Config Server README

This module provides centralized configuration management using Spring Cloud Config Server. It allows microservices to retrieve their configurations dynamically from a central location.

## Features
- Centralized configuration for all services.
- Supports profiles (e.g., dev, test, prod).
- Built-in support for Git as the configuration source.

## How to Run
1. Navigate to the config service directory:
   ```bash
   cd config-server
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
Specify the Git repository for configuration in `application.yml` and ```configurations``` folder:

```yaml
spring:
  cloud:
    config:
      server:
        native:
          search-locations: classpath:/configurations
```

Clients can fetch configurations using the following URL pattern:
```
http://<config-service-host>:<port>/<application-name>/<profile>
