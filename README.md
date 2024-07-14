
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

## Folder Structure
```
YourProjectName/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   ├── yourprojectname/
│   │   │   │   │   ├── pages/
│   │   │   │   │   │   ├── BasePage.java
│   │   │   │   │   │   ├── HomePage.java
│   │   │   │   │   │   ├── LoginPage.java
│   │   │   │   │   │   ├── SignupPage.java
│   │   │   │   │   │   └── (other pages).java
│   │   │   │   │   ├── utils/
│   │   │   │   │   │   ├── ExcelDataReader.java
│   │   ├── test/
│   │   │   ├── java/
│   │   │   │   ├── com/
│   │   │   │   │   ├── yourprojectname/
│   │   │   │   │   │   ├── steps/
│   │   │   │   │   │   │   ├── LoginSteps.java
│   │   │   │   │   │   │   ├── SignupSteps.java
│   │   │   │   │   │   │   └── (other steps).java
│   │   │   │   │   │   ├── runners/
│   │   │   │   │   │   │   └── TestRunner.java
│   │   │   │   │   │   ├── listeners/
│   │   │   │   │   │   │   └── ExtentReportListener.java
│   │   ├── resources/
│   │   │   ├── driver/
│   │   │   │   └── chromedriver.exe
│   │   │   ├── testdata/
│   │   │   │   └── Sheet.xlsx
│   │   │   └── testoutput/
│   │   │       ├── extent-report.html
│   │   │       └── (other output files)
│   │   ├── features/
│   │   │   ├── Login.feature
│   │   │   ├── Signup.feature
│   │   │   └── (other feature files).feature
├── pom.xml
└── (other project files)
```

## Setup Instructions
1. **Clone the repository:**
   ```sh
   git clone https://github.com/yourusername/yourprojectname.git
   cd yourprojectname
   ```

2. **Install project dependencies:**
   Ensure you have Maven installed and run:
   ```sh
   mvn clean install
   ```

3. **Add ChromeDriver:**
   Place the `chromedriver.exe` file in the `src/test/resources/driver/` directory.

4. **Update Excel Test Data:**
   Update the `Sheet.xlsx` file in the `src/test/resources/testdata/` directory with your login and signup credentials.

## Running the Tests
1. **Execute the test suite:**
   ```sh
   mvn test
   ```

2. **Run specific feature files:**
   You can configure the runner class `TestRunner.java` to specify particular feature files or tags.

## Generating Reports
After executing the tests, the Extent Reports will be generated in the `src/test/resources/testoutput/` directory:
- Open `extent-report.html` to view the detailed test report.

## Data-Driven Testing
The framework supports data-driven testing for user login and signup functionalities using the `Sheet.xlsx` file. The `ExcelDataReader.java` utility class reads data from this file.

## Contributing
1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Commit your changes (`git commit -m 'Add some feature'`).
4. Push to the branch (`git push origin feature-branch`).
5. Open a pull request.

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
