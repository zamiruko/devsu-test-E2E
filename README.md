
# End-to-End Automated Test Suite for Web Application Purchase Flow

## Overview

This project is designed to automate the purchase flow of a web application using Selenium WebDriver, Cucumber, and Java. The suite covers the end-to-end purchase process, including adding products to the cart, viewing the cart, completing the purchase form, and finalizing the purchase.

## Prerequisites

Before setting up the project, ensure you have the following installed:
- **Java Development Kit (JDK) 17**: Required for running the Java application.
- **Maven**: Necessary for project build and dependency management.
- **IntelliJ IDEA**: Recommended IDE for running and writing tests.
- **Web Browser Drivers**: Ensure you have the appropriate WebDriver for the browser you plan to test with.

## Project Structure

- **src/main/java**: Contains the Page Object Models and utility classes for the test.
- **src/test/java**: Contains the step definitions and test runners.
- **src/main/resources**: Includes configuration files and JSON files for page elements.
- **src/test/resources**: Contains the Cucumber feature files.

## Setup

1. Clone the repository and navigate to the project directory.
2. Open the project in IntelliJ IDEA.
    - The IDE should automatically recognize the Maven structure and import the necessary dependencies based on the `pom.xml` file.

## Running Tests

Tests can be executed in two ways:

1. **Via IntelliJ IDEA**:
    - Navigate to `src/test/java/com/devsu/automation/runner/SuiteTestRunner.java`.
    - Right-click on the file and select `Run 'SuiteTestRunner'`.

2. **Via Maven Command**:
    - Open a terminal in the project directory.
    - Execute the command: `mvn clean test`.

## Libraries Used
- Selenium WebDriver (selenium-java) version 4.0.0
- WebDriver Manager (webdrivermanager) version 5.0.3
- Cucumber for Java (cucumber-java) and Cucumber for JUnit (cucumber-junit) version 7.0.0
- JUnit Jupiter API and JUnit Jupiter Engine (junit-jupiter) version 5.8.2
- Slf4j Simple Binding (slf4j-simple) version 1.7.32 (optional for logging)
- JSON-simple (json-simple) version 1.1.1 for JSON handling
- Log4j (log4j) version 1.2.17 for logging

## Viewing Reports

Cucumber generates detailed HTML reports after the test execution. These can be found under the `target/cucumber-reports.html` directory.

## Continuous Integration

The suite can be configured to run with CI tools like Jenkins for automated test execution upon new code commits.

## Additional Notes
- Cucumber BDD is used to describe test scenarios, with feature files located in `src/test/resources/features`.
- Test data and element selectors are stored in JSON files in the `src/main/resources/Pages` directory.
- Test reports can be found at `target/cucumber-reports.html` after test execution.

## License

This project is licensed under the [Devsu.com](LICENSE).

