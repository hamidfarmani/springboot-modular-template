# Cookiecutter Template for Modular Spring Boot Projects

This repository contains a Cookiecutter template for bootstrapping modular Spring Boot projects. It simplifies the process of setting up a project with features like Eureka Discovery, API Gateway, Config Server, Auth service with JWT and more. The template is customizable and designed to save time when creating new projects.

---

## What is Cookiecutter?

[Cookiecutter](https://cookiecutter.readthedocs.io/) is a command-line tool that creates projects from templates. It allows you to define variables and logic in your template, making it easy to generate tailored project structures.

---

## Features

- Modular project setup with:
    - **Config Service**: Centralized configuration using Spring Config.
    - **Discovery Service**: Service discovery using Eureka.
    - **API Gateway**: A gateway for routing requests.
    - **Auth Service**: A microservice that does registration and login based on JWT and Spring Security.
- Automated Git initialization.

---

## Prerequisites

1. **Install Cookiecutter**: You can follow the instructions [here](https://cookiecutter.readthedocs.io/en/stable/installation.html) to install Cookiecutter. For example, using pip:
   ```bash
   pip install cookiecutter
   ```

   Make sure Python is installed on your system before running the command.

2. **Java Development Kit (JDK)**: Ensure JDK is installed. Recommended version: `21`.
3. **Maven**: Install Apache Maven for managing dependencies and builds.

---

## How to Use the Template

### Step 1: Generate a New Project

Run the following command to generate a project:

```bash
cookiecutter https://github.com/hamidfarmani/springboot-modular-template
```

You will be prompted to provide details like:
- Project name
- Package name
- Java version
- Modules to include (e.g., Config Server, API Gateway, Discovery Service)

### Step 2: Navigate to the Project Directory

```bash
cd <your_project_name>
```

### Step 3: Build the Project

Use Maven to build the project:

```bash
mvn clean install
```

### Step 4: Run the Services

You can run each module individually. For example:

```bash
cd config-service
mvn spring-boot:run
```

Repeat for other modules like `discovery-service` or your sample microservice.

---

## Repository Structure

```plaintext
├── {{cookiecutter.project_name}}/
│   ├── config-service/          # Config Server module
│   ├── discovery-service/       # Eureka Discovery module
│   ├── api-gateway/             # API Gateway module
│   ├── pom.xml                  # Parent POM for the modular project
│   └── README.md                # Documentation for the generated project
├── cookiecutter.json            # Variables for the template
└── hooks/                       # Pre- and post-generation scripts
    ├── pre_gen_project.py       # Pre-generation checks and validations
    └── post_gen_project.py      # Post-generation tasks (e.g., Git setup)
```

---

## Customization

### Modify Template Variables

To adjust the template, edit the `cookiecutter.json` file. For example:

```json
{
  "project_name": "my-new-project",
  "package_name": "com.example.project",
  "java_version": "21",
  "spring_boot_version": "3.4.1",
  "include_discovery_service": "y",
  "include_api_gateway": "n"
}
```

### Add New Modules

To add new modules, create a new folder in the template and define its structure. Update the `cookiecutter.json` file and parent `pom.xml` to include the new module.

---

## Contributing

Contributions are welcome! If you have ideas to improve the template, feel free to open an issue or submit a pull request.

---

## License

This repository is licensed under the [MIT License](LICENSE).
