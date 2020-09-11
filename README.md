## How to build

This project uses `JAVA 12 SDK` make sure you have it installed before you proceed.
In the `root` folder of the project, open console and type: 

```cmd
  gradlew build
```

This also generates OpenAPI 3 documentation in `build/classes/java/main/META_INF/swagger` folder.

## How to start

The main class of the application is `com.cobrick.Application` and is using classpath of module `demotask.main`.

After building application, in the `root` folder of the project, open console and type: 

```cmd
  gradlew run
```

The application should start listening on port `8080`.
If you want to change the port, you can do this by changing this property in `application.yml` file:

```cmd
  server:
    port: 8080
```

## How to test

In the `root` folder of the project, open console and type: 

```cmd
  gradlew test
```

The tests cover ColorController and ColorFilter functionality.

## Feature rabbitmq documentation

- [Micronaut RabbitMQ Messaging documentation](https://micronaut-projects.github.io/micronaut-rabbitmq/latest/guide/index.html)

## Feature openapi documentation

- [Micronaut OpenAPI Support documentation](https://micronaut-projects.github.io/micronaut-openapi/latest/guide/index.html)

- [https://www.openapis.org](https://www.openapis.org)

## Feature http-client documentation

- [Micronaut Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#httpClient)

