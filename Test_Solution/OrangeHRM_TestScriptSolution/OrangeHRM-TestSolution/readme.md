# OrangeHRM Employee Lifecycle Automation Framework

## About the Project

This project automates the Employee Lifecycle workflow in OrangeHRM using Selenium WebDriver, Java, TestNG, and Maven.

The framework follows the Page Object Model (POM) design pattern and includes both UI and API automation. It is designed to be scalable, maintainable, and easy to extend for future test scenarios.

The project covers employee management workflows such as employee creation, employee search, employee details updating, employee deletion and API validation.

## Technologies Used

- Java 18
- Selenium WebDriver
- TestNG
- Maven
- REST Assured
- Extent Reports
- Page Object Model (POM)

## Project Structure

OrangeHRM-TestSolution
└─────
	src/main/java
	└─────
		baseTest
		└── BaseClass.java

		listeners
		└── TestListener.java

		model
		└── EmployeeData.java

		pages
		├── AddEmployeePage.java
		├── DashboardPage.java
		├── EmployeeListPage.java
		└── LoginPage.java

		retry
		└── RetryAnalyzer.java

		utils
		├── ConfigReader.java
		├── DriverFactory.java
		├── ExtentManager.java
		├── JsonReader.java
		├── ScreenShotScript.java
		└── waitUtils.java

	src/test/java
	└─────
		api
		└── EmployeeAPITest.java

		resources
		├── config.properties
		└── employee.json

		tests
		└── EmployeeLifeCycleTest.java

	Project Files
		├── pom.xml
		├── testng.xml
		├── target
		└── test-output

## Framework Components

### Base Test

"BaseClass.java" handles browser initialization, test setup, and teardown operations.

### Page Classes

The pages package implements the Page Object Model pattern.

- LoginPage handles login functionality.
- DashboardPage manages dashboard-related actions.
- AddEmployeePage manages employee creation.
- EmployeeListPage handles employee search, validation, updation and deletion.

### Model

"EmployeeData.java" is used to store and map employee information from test data files.

### Utilities

The utilities package contains reusable helper classes:

- ConfigReader for reading configuration values.
- DriverFactory for WebDriver management.
- JsonReader for reading employee test data.
- waitUtils for synchronization and waits.
- ScreenShotScript for capturing screenshots.
- ExtentManager for report generation.

### Listener

"TestListener.java" captures test execution events and updates reporting.

### Retry Mechanism

"RetryAnalyzer.java" automatically retries failed test cases based on configured retry settings.

### API Testing

"EmployeeAPITest.java" contains API validation scenarios for employee operations.

### UI Testing

"EmployeeLifeCycleTest.java" contains end-to-end employee lifecycle validation scenarios.

## Setup Instructions

### Prerequisites

Install the following before running the project:

- Java JDK 18
- Maven latest version higher
- Google Chrome
- Eclipse


## Configuration

Application properties are stored in:

src/test/java/resources/config.properties

## Test Data

Employee test data is maintained in:

src/test/java/resources/employee.json

This allows test data updates without changing test scripts.

## How to Run the Tests

1) Run All Tests:- 
	mvn test

2) Run Using TestNG Suite:- 
	mvn test -DsuiteXmlFile=testng.xml

### Run from IDE

1. Open the project in Eclipse.
2. Open testng.xml.
3. Right-click and select Run as TestNG Suite.

## Test Coverage

### UI Automation

- User Login
- Add Employee
- Employee Search
- Employee Information Validation
- Complete Employee Lifecycle Flow

### API Automation

- Employee API Validation
- Request and Response Verification
- JSON Payload Validation
- Status Code Validation

## Reporting

Execution reports are generated inside:-

	"test-output" folder

Extent Reports provide detailed execution results along with screenshots for failed test cases.

## Dependencies

Main dependencies used in the framework:

- Selenium WebDriver
- TestNG
- REST Assured
- WebDriverManager
- Extent Reports
- Maven

All dependencies are managed through `pom.xml`.

## Design Patterns Used

- Page Object Model (POM)
- Factory Pattern
- Singleton Pattern
- Data-Driven Testing
- Retry Mechanism
