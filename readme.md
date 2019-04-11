# BDD Workshop with Java

Implementation of a simple login scenario

## Prerequisites



[IntelliJ Community/Ultimate Edition](https://www.jetbrains.com/idea/download)
    
    -install "Cucumber for Java" plugin

[JDK 1.8+](https://www.oracle.com/technetwork/java/javaee/downloads/jdk8-downloads-2133151.html)

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

JaCoCo Report
```
/target/site/jacoco-ut/index.html
```
