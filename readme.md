# BDD Workshop with Java

Implementation of a simple login scenario

## Prerequisites


```
Cucumber supported IDE(IntelliJ, Eclipse vb)
JDK 1.8+
Maven
```

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