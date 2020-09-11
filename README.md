## How to build

This project uses `JAVA 12 SDK` make sure you have it installed before you proceed.
In the `root` folder of the project, open console and type: 

```cmd
  gradlew build
```

This also generates OpenAPI 3 documentation in `build/classes/java/main/META_INF/swagger` folder.

## How to start

This project uses RabbitMQ server. Make sure you have one running before you start the application.
The application generates needed exchanges and queues if they are not present.
RabbitMQ connection settings can be changed in `application.yml` file:

```cmd
  uri: "${RABBITMQ_URI:`amqp://localhost:5672`}"
  username: "${RABBITMQ_USERNAME:`guest`}"
  password: "${RABBITMQ_PASSWORD:`guest`}"
  exchange: "cobrick"
  queue: "colors"
```

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

