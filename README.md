# BackendBlass API Automation - Playwright Java - TAREA

API test automation for the BackendBlass project using **Playwright** with **Java** and dependency management via **Maven**.  
The workflow follows the **GitHub Flow** standard for agile and collaborative development.

---

## 📚 About the Project

This repository contains automation scripts for functional testing of the BackendBlass REST API endpoints.
The tests focus on validating individual endpoint behavior, including CRUD operations for Participantes and Video Games flows.
The goal is to ensure each API endpoint functions correctly according to specifications and business rules.
The APIs to be tested are documented here:  
[BackendBlass API Documentation](https://documenter.getpostman.com/view/7849298/2sB2ca7fHY#f229d239-20de-4633-8114-22471f54e98a)  

Main backend repository:  
[BackendBlass on GitHub](https://github.com/calvario31/BackendBlassAcademy?tab=readme-ov-file)

---

## ⚙️ Technologies and Tools

- **Language:** Java 17+ (e.g. [Oracle JDK 17.0.12 - Windows x64 Installer](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html))
- **Test Framework:** Playwright for Java with JUnit 5
- **Build & Dependency Management:** Maven 3.6+ ([Download Maven](https://maven.apache.org/download.cgi)) *e.g., apache-maven-3.9.9-bin.zip*
- **Version Control:** [Git](https://git-scm.com/downloads) with GitHub Flow Workflow
- **Recommended IDE:** [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/download/?section=windows) or any Maven and Java compatible IDE

---

## 🚀 Environment Setup (Prerequisites)

- Java JDK 17 or higher installed and configured in PATH  
- Maven installed (version 3.6 or higher)  
- Git installed  
- IntelliJ IDEA or a compatible IDE with Maven and Java support  
- Internet access to download Maven dependencies  
- Verify installations with:  
`java -version`  
`mvn -version`  
`git --version`

---
## 🛠️ Project Setup and Initial Testing Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/ecossio7/backendblass-api-playwright-java.git
cd backendblass-api-playwright-java
```

### 2. Import Project into IntelliJ IDEA

- Open IDE 
- Select **Open** and navigate to the cloned project directory  
- IntelliJ will auto-detect the Maven project and download dependencies  

### 3. Project Structure
```
src/
 ├── main/java          # Base code if needed
 └── test/java          # Playwright test scripts
pom.xml                 # Maven configuration and dependencies
README.md               # Project documentation
```

### 4. Run Tests

From the terminal inside the project root, run:

```bash
mvn clean test
```
This command cleans the previous build artifacts and compiles the project. Maven will automatically download any missing dependencies, then it runs all automated tests.

### 5. Customize Configuration
- Modify `pom.xml` to add dependencies or plugins as needed
- Update scripts under `src/test/java` to add or change test cases

---

### 🔀 GitHub Flow Workflow
Always branch off from `main`. Use this branch naming convention:

- `feature/<description>` - For new features
- `issue/<id>-<description>` - For bug fixes or specific tasks
- `hotfix/<description>` - For urgent fixes

Always create a Pull Request for review before merging into `main`.

Keep `main` branch stable and deployable at all times.

## Project Structure

This project follows the standard Maven directory layout, which promotes clear organization and ease of maintenance:

```
src/
├── main/java # Application source code (if applicable)
└── test/java # Automated test scripts using Playwright
pom.xml # Maven build configuration and dependency management
README.md # Project documentation and instructions
```
