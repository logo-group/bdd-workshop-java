# BDD Workshop with Java

Implementation of a simple login scenario

## Prerequisites



[IntelliJ Community/Ultimate Edition](https://www.jetbrains.com/idea/download)

JDK 1.8+

[Maven 3](https://maven.apache.org/download.cgi)


### Built With

```
Spring Boot
Serenity
Cucumber
H2 (in-memory database)
```

## Installation

Clone the project and let maven download required dependencies.

```
mvn clean install
```

## Running Application

```
mvn spring-boot:run
```

## Running Tests

Running Tests
```
mvn clean test
```

Running Tests with serenity report
```
mvn clean test serenity:aggregate
```

Serenity Report
```
/target/site/serenity/index.html
```
