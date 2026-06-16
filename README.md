# Selenium TestNG Automation Framework

## Overview

This repository contains a scalable UI Automation Framework built using Selenium WebDriver, Java, Maven, and TestNG. The framework follows industry-standard design patterns and best practices to support maintainable, reusable, and robust automated test execution.

The framework is designed to support:

* Cross-browser testing
* Parallel execution using ThreadLocal WebDriver
* Environment-based configuration
* Page Object Model (POM)
* Centralized reporting
* Test listeners
* Reusable utility components

---

## Tech Stack

| Technology         | Purpose                       |
| ------------------ | ----------------------------- |
| Java 17            | Programming Language          |
| Selenium WebDriver | Browser Automation            |
| TestNG             | Test Execution Framework      |
| Maven              | Build & Dependency Management |
| Extent Reports     | Reporting                     |
| WebDriverManager   | Driver Management             |
| Log4j              | Logging                       |
| Git & GitHub       | Version Control               |

---

## Framework Design

### Design Patterns Implemented

* Page Object Model (POM)
* Singleton Pattern
* Factory Pattern
* ThreadLocal Pattern for WebDriver Management
* Utility Layer Abstraction

### Framework Structure

```text
src/test/java
├── base
├── config
├── listeners
├── locators
├── pages
├── tests
├── utils

resources
├── config.properties

root folder
├── testng.xml
```

---

## Key Features

### Browser Support

* Chrome
* Firefox (extendable)

### Parallel Execution with ThreadLocal

The framework supports parallel test execution using TestNG and a ThreadLocal WebDriver implementation. Each test thread maintains its own WebDriver instance, ensuring thread safety and eliminating driver conflicts during concurrent execution.

Benefits:

* Faster execution time
* Improved scalability
* Thread-safe WebDriver management
* Better resource utilization

### Environment Configuration

Framework execution can be controlled through configuration files and runtime parameters.

Example:

```bash
mvn test -Dbrowser=chrome -Denv=qa
```

### Reporting

* Extent Reports integration
* Pass / Fail screenshots
* Execution summary

### Logging

Integrated logging mechanism for easier debugging and execution tracking.

---

## Sample Test Execution

Run all tests:

```bash
mvn clean test
```

Run a TestNG suite:

```bash
mvn test -DsuiteXmlFile=testng.xml
```

Run specific browser:

```bash
mvn test -Dbrowser=chrome
```

---

## Framework Highlights

* Thread-safe WebDriver implementation using ThreadLocal
* Parallel execution support through TestNG
* Clean separation of test and page layers
* Reusable page components
* Scalable and maintainable architecture
* Environment-driven execution
* Supports future CI/CD integration

---

## Future Enhancements

* Jenkins CI/CD Integration
* Docker Execution
* Selenium Grid Support
* API Automation Integration
* AI-assisted Test Analysis
* Cloud Execution (BrowserStack / LambdaTest)

---

## Author

**Arzoo Hingorani**

Senior SDET | Test Automation Engineer

**Skills:** Java • Selenium • TestNG • Maven • API Testing • SQL • CI/CD • Automation Framework Design
