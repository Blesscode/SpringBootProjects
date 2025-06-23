# 🌿 Spring MVC Interceptor Concept Introduction and application in calculating the processing time of each request

In the current project we will understand a use case of interceptor and see how interceptors works in spring boot.
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

- Interceptors are used to perform common logic. That is it performs the common task that is required in each request
- This reduces the efforts of implementing the common task again and agin in each controller
- The interceptors works in 3 cases:
  - Before Controller: Before the the request reaches the controller
  - After Controller Before Client : Before the result is shown to the client
  - After Client : After the result is shown to the client 
- Use Cases
 - Authentication
 - Processing time per each request
 - Log the request data
---

## 📚 Technologies & Dependencies

| Tool/Library              | Purpose                                    | Type                |
| ------------------------- | ------------------------------------------ | ------------------- |
| `Spring Boot`             | Base framework                             | Core Technology     |
| `Spring MVC`              | Web MVC architecture                       | Core Technology     |
| `spring-boot-devtools`    | Hot reload during development              | External Dependency |
| `spring-boot-starter-web` | Adds Spring MVC, REST, and embedded Tomcat | External Dependency |


## 🚀 Getting Started

### ✅ Prerequisites

- Java 8 or later
- Maven or Gradle
- IDE (Eclipse, IntelliJ, VS Code)
- Date Time in Java

### 🔧 Steps to Run

1. **Clone the repository**

   ```bash
   git clone https://github.com/your-username/spring-form-project.git

   cd spring-form-project
   ```

2. **Open the project in your IDE**

3. **Run the application**

   - Right-click the main class → Run as Spring Boot App

   **OR use terminal:**

   ```
   ./mvnw spring-boot:run

   ```

4. **Access the page**

   ```
   http://localhost:8080/
   ```
   output will be shown on the terminal
   
[🛠️ Project Structure](#-project-structure)

```
6InterceptorProcessingTime
|__src
|    |__main
|         |__java
|              |__com.interceptor =>Application.java
|                    |_com.interceptor.Binding
|                    |_com.interceptor.Controller
|                    |__com.interceptor.Configuration 
|                    
|                       
|                   
|__src/main/resources
|              |_templates => index.html
|__src/test/java
|__src/main/webapp/views
|__ pom.xml

```

## 🎯 Future Enhancements

1. ✅ Add Automation test cases
2. 🎨 Improve UI

## 📝 Notes

- Ensure the packaging type is set to war, not jar, to support web based Application.
- The dispatcher servlet will not automatically know that a interceptor is present in your project : you have to create a configuration file and in that tell the dispatch servlet that there is an interceptor present in your project 
  - To do so
    1. Extend the properties of HandleInterceptor
    2. Add interseptor method to add interceptor in intercptor registry
- Interceptor has 3 methods 
  - PreHandle
  - PostHandle
  - afterCompleteHandle
