# 🌿 Spring MVC User Search Page **THYMELEAF**

Following project is user search page project build with spring boot + thymeleaf utilizing concepts like [SOLID Design Principles + Spring MVC + Bootstrap + JSP + Apache POI + Open Pdf + Thymeleaf + Lombok]

---

## 📘 Table of Contents

- [🌟 Features](#-features)
- [📚 Technologies & Dependencies](#-technologies--dependencies)
- [🚀 Getting Started](#-getting-started)
- [🎯 Future Enhancements](#-future-enhancements)
- [🛠️ Project Structure](#-project-structure)
- [📝 Notes](#-notes)

---

## 🌟 Features

- Implemented using **SOLID** Desing principles
- Find user from the database based on the search filter choosed
- Download report as excel or pdf at your browser
- Display records on the ui based on the search filter
- Responsive UI

---

## 📚 Technologies & Dependencies

| Tool/Library                    | Purpose                                    | Type                |
| ------------------------------- | ------------------------------------------ | ------------------- |
| `Spring Boot`                   | Base framework                             | Core Technology     |
| `Spring MVC`                    | Web MVC architecture                       | Core Technology     |
| `Thymeleaf`                     | View technology                            | External Dependency |
| `spring-boot-devtools`          | Hot reload during development              | External Dependency |
| `spring-boot-starter-web`       | Adds Spring MVC, REST, and embedded Tomcat | External Dependency |
| `spring-boot-starter-data-jpa`  | Adds Spring data JPA options               | External Dependency |
| `spring-boot-starter-thymeleaf` | Adds Thymeleaf to our project              | External Dependency |
| `mysql-connector-j`             | Adds MySQL driver                          | External Dependency |
| `lombok`                        | To ease getters,setters & toString options | External Dependency |
| `poi-ooxml`                     | For java to excel operations               | External Dependency |
| `openpdf`                       | For java to pdf operations                 | External Dependency |

## 🚀 Getting Started

### ✅ Prerequisites

- Java 8 or later
- Maven or Gradle
- IDE (Eclipse, IntelliJ, VS Code)
- Spring Boot + Thymeleaf + HTML + CSS + JS

### 🔧 Steps to Run

1. **Clone the repository**

   ```bash
   git clone https://github.com/your-username/spring-project.git

   cd spring-project
   ```

2. **Open the project in your IDE**

3. **Run the application**

   - Right-click the main class → Run as Spring Boot App

   **OR use terminal:**

   ```
   ./mvnw spring-boot:run

   ```

4. **Access the form**

   ```
   http://localhost:8080/
   ```

   perform actions visible on UI

[🛠️ Project Structure](#-project-structure)

```
12SearchPage
|__src
|    |__main
|         |__java
|              |__com.searchpage
|                    |=>Application.java
|                    |=>ServletInitializer.java
|                    |_com.searchpage.binding
|                         |=>SearchRequest.java
|                    |_com.searchpage.controller
|                         |=>SearchPageController.java
|                    |_com.searchpage.entity
|                         |=>DataEntity.java
|                    |_com.searchpage.repository
|                         |=>DataRepository.java [I]
|                    |_com.searchpage.runner
|                         |=>ApplicationStarter.java
|                    |_com.searchpage.service
|                         |=>SearchService.java [I]
|                         |=>SearchServiceImplementation.java
|                    |_com.searchpage.helper
|                         |=>ExportToExcel.java
|                         |=>ExportToPdf.java
|__src
|    |__main
|         |__resources
|                    |_static
|                         |=>index.js
|                         |=>style.css
|                    |_templates
|                         |=>SearchPage.html
|                    |=>Application.properties
|__src/test/java
|__src/main/webapp/views
|__ pom.xml

```

## 🎯 Future Enhancements

1. ➿ Add Automation test cases
2. ➕ Add more pages or use the component in the microservice-arch

## 📝 Notes

- Runner is to initialize data in database i.e. the data is already present in the db the user data is not entered by user
- The runner runs always the application is started or refreshed, so re-entry of data should be aprevented
- Service has an interface and a implementation class of that interface
- Every action in the UI that need the db action should go through controller then service then to db that's why we have a service for status too because we cannot directly comm to db
- Each service should implement only 1 functionality that's why we keept the implementation into helper classes following SOLID principles
