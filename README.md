# EspoCRM QA Automation Project

## Project Overview

This project is a structured Software Quality Assurance and Test Automation project based on EspoCRM. It covers manual testing, requirements traceability, defect reporting, selected Selenium UI automation, and supporting API, SQL, Git/GitHub and Jenkins activities planned across the project lifecycle.

## Application Under Test

EspoCRM 10.0.4

Local URL:

http://localhost:8081

## Current Active QA Scope

- Login / Authentication
- Accounts
- Contacts

Leads and Opportunities were part of the earlier project baseline but are **de-scoped from the active project due to project time constraints**. Their earlier artifacts are retained only as historical records and are not part of the current requirements, execution or automation baseline.

## Current Manual QA Baseline

- **54 represented functional requirements**
- **71 test scenarios**
- **90 detailed test cases**
- **89 Passed**
- **1 Failed**
- **2 open defects:** BUG-ACC-001 and BUG-CON-001

## Project Objectives

- Perform functional and regression testing
- Design and maintain traceable test scenarios and test cases
- Maintain a consolidated Requirements Traceability Matrix (RTM)
- Report and track defects
- Automate selected stable workflows using Selenium WebDriver
- Apply Java, TestNG, Maven and Page Object Model practices
- Perform supporting API and SQL/database validation
- Manage source code using Git and GitHub
- Execute automation through Jenkins when the CI phase is implemented
- Generate test execution and automation reports

## Testing Approach

### Functional Testing

The current functional baseline covers Login, Accounts and Contacts, including applicable CRUD workflows, validation, search/filtering, relationships, access behavior and other configured module functionality represented in the active requirements.

### Automation Testing

- Selenium WebDriver
- Java
- TestNG
- Page Object Model
- Maven
- Git / GitHub

### API Testing

Planned/supporting API validation for the active Login, Accounts and Contacts scope.

### Database Testing

Planned/supporting SQL validation for the active scope using the authorized EspoCRM test database.

### CI/CD

- Jenkins
- Maven
- Git / GitHub

## Technology Stack

| Category | Technology |
|---|---|
| Application | EspoCRM 10.0.4 |
| Containerization | Docker |
| Database | MariaDB |
| Operating System | Windows test workstation |
| Linux Environment | WSL 2 / Ubuntu |
| Programming Language | Java |
| UI Automation | Selenium WebDriver |
| Test Framework | TestNG |
| Build Tool | Maven |
| API Testing | Postman |
| Database Testing | SQL / MariaDB |
| Version Control | Git / GitHub |
| CI/CD | Jenkins |

## Active Project Structure

The repository is organized around the current three-module QA baseline:

- 01-Requirements
- 02-Test-Plan
- 03-Test-Cases
- 04-RTM
- 05-Bug-Reports
- 06-Test-Reports
- 11-Test-Reports (historical/module execution records)
- docs/test management
- espocrm-docker
- selenium-automation
- README.md

## Traceability

Functional Requirement (FR) → Test Scenario (TS) → Test Case (TC) → RTM / Execution Evidence

The Master RTM is the active consolidated traceability artifact for the current scope. The Master Bug Report is the active consolidated defect artifact.

## Defect Baseline

Two confirmed/open defects remain in the current manual-testing baseline:

- **BUG-ACC-001:** Accounts Audit Log displays “Locked” after an Account is unlocked.
- **BUG-CON-001:** Contacts Starred Email selection is not visibly retained after saving and reopening a Contact.

