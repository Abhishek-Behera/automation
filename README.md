
# E-Commerce Automation Framework

This repository contains a BDD-based test automation framework for an e-commerce application using Selenium WebDriver, Java, Cucumber, and the Page Object Model (POM) pattern.

## Table of Contents
- [Prerequisites](#prerequisites)
- [Folder Structure](#folder-structure)
- [Setup Instructions](#setup-instructions)
- [Running the Tests](#running-the-tests)
- [Generating Reports](#generating-reports)
- [Data-Driven Testing](#data-driven-testing)
- [Contributing](#contributing)
- [License](#license)

## Prerequisites
Before you begin, ensure you have met the following requirements:
- Java JDK 8 or higher installed
- Maven installed
- Chrome browser installed
- Chromedriver according to chrome version

## Folder Structure
```
Automation/
├── .idea/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── org/
│   │   │   │   ├── example/
│   │   │   │   │   ├── Main.java
│   │   │   ├── pages/
│   │   │   │   ├── BasePage.java
│   │   │   │   ├── CartPage.java
│   │   │   │   ├── CheckoutPage.java
│   │   │   │   ├── HomePage.java
│   │   │   │   ├── LoginPage.java
│   │   │   │   ├── ProductPage.java
│   │   │   │   ├── SignupPage.java
│   │   │   ├── utility/
│   │   │   │   ├── ExcelDataReader.java
│   │   ├── resources/
│   ├── test/
│   │   ├── java/
│   │   │   ├── listeners/
│   │   │   │   ├── ExtentReportListener.java
│   │   │   ├── runners/
│   │   │   │   ├── TestRunner.java
│   │   │   ├── stepDefinitions/
│   │   │   │   ├── CartStep.java
│   │   │   │   ├── CheckoutStep.java
│   │   │   │   ├── LoginStep.java
│   │   │   │   ├── ProductStep.java
│   │   │   │   ├── SignupStep.java
│   │   ├── resources/
│   │   │   ├── drivers/
│   │   │   │   ├── chromedriver.exe
│   │   │   ├── features/
│   │   │   │   ├── Cart.feature
│   │   │   │   ├── Checkout.feature
│   │   │   │   ├── Login.feature
│   │   │   │   ├── Product.feature
│   │   │   │   ├── Signup.feature
│   │   │   ├── testData/
│   │   │   │   ├── Sheet.xlsx
├── target/
├── testoutput/
│   ├── extent-report.html
├── .gitignore
├── pom.xml
└── (other project files)

```

## Setup Instructions
1. **Clone the repository:**
   ```sh
   git clone https://github.com/Abhishek-Behera/automation.git
   cd automation
   ```

2. **Install project dependencies:**
   Ensure you have Maven installed and run:
   ```sh
   mvn clean install
   ```

3. **Add ChromeDriver:**
   Place the `chromedriver.exe` file in the `src/test/resources/drivers/` directory.

4. **Update Excel Test Data:**
   Update the `Sheet.xlsx` file in the `src/test/resources/testdata/` directory with your login and signup credentials.

## Running the Tests
1. **Execute the test suite:**
   ```sh
   mvn test
   ```
2. **Running tests in IntelliJ IDEA:**
   
   Open the project in IntelliJ IDEA.
   Navigate to src/test/java/runners/TestRunner.java.
   Right-click on the TestRunner class and select Run 'TestRunner'.

4. **Run specific feature files:**
   You can configure the runner class `TestRunner.java` to specify particular feature files or tags.

## Generating Reports
After executing the tests, the Extent Reports will be generated in the `src/test/resources/testoutput/` directory:
- Open `extent-report.html` to view the detailed test report.

## Data-Driven Testing
The framework supports data-driven testing for user login and signup functionalities using the `Sheet.xlsx` file. The `ExcelDataReader.java` utility class reads data from this file.


