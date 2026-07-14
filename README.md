# sample_java_project

Base Spring Boot REST service starter project with sensible defaults for API development and testing.

## Stack

- Java 21
- Spring Boot 3.3.x
- Spring Web + Validation + Actuator
- OpenAPI/Swagger UI via springdoc
- JUnit 5 + MockMvc + Spring Boot test support
- JaCoCo coverage reports

## Project Layout

- `src/main/java` application code (controller, service, error handling)
- `src/main/resources/application.yml` app configuration
- `src/test/java` unit, web-layer, context, and integration tests
- `src/test/resources/application-test.yml` test profile config

## Run Locally

```bash
mvn spring-boot:run
```

App endpoints of interest:

- `GET /api/v1/greetings/{name}`
- `GET /actuator/health`
- `GET /api-docs`
- `GET /swagger-ui.html`

## Test Commands

Run fast tests (unit + web layer):

```bash
mvn test
```

Run full verification (includes integration tests and JaCoCo report):

```bash
mvn verify
```

JaCoCo HTML report after `mvn verify`:

- `target/site/jacoco/index.html`
