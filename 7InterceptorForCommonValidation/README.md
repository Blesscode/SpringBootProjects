# 🌿 Spring MVC Interceptor Concept To perform Common validation of a user

In the current project we will understand a use case of interceptor and see how interceptors eliminates the code duplication problem of writing common user authentication in each controller by providing a checker before all controllers so that only authentic requests moves forward .
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

- Interceptors are used to perform common logic.
- Here we will see a use case where rather than performing a check that the user is valid in each controller we perform this step in an interceptor.
- Each request 1st reaches to the interceptor through: preHandle which check the authentication then only allow the authentic user to more forward.
- Here rather than implementing full use case there is only explainatory code present so as to provide how the interceptor works in this use case
- Here if username is **StoreCustomer** then only the entry/request will move forward to rest controllers else the access will be denied
  - i.e.
    - **CASE 1** :  If the request is of type **http://localhost:8080/welcome?CustomerId=abc** i.e. wrong useranme then the result will be access denied and the message shown will be  invalid user
    - **CASE 2** :  If the request is of type **http://localhost:8080/welcome?CustomerId=StoreCustomer** i.e. correct useranme then the result will be access granted and the message shown will be  hello 

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
- Spring Boot Basics
- Spring Boot Controllers
- Basics of Interceptors

### 🔧 Steps to Run

1. **Clone the repository**

   ```bash
   git clone https://github.com/your-username/project-name.git

   cd project-name
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
    Case 1 : http://localhost:8080/welcome?CustomerId=abc
    Case 2 : http://localhost:8080/welcome?CustomerId=StoreCustomer
   ```
  
   
[🛠️ Project Structure](#-project-structure)

```
7InterceptorForCommonValidation
|__src
|    |__main
|         |__java
|              |__com.interceptor =>Application.java
|                    |_com.interceptorValidate.interceptor
|                    |_com.interceptorValidate.controller
|                    |__com.interceptorValidate.configuration 
|                 
|__src/main/resources
| 
|__src/test/java
|__src/main/webapp/views
|__ pom.xml

```

## 🎯 Future Enhancements

1. ✅ Add Automation test cases
2. 🎨 Improve UI
3. 💡 Handle better authentication

## 📝 Notes

- Ensure the packaging type is set to war, not jar, to support web based Application.
- The dispatcher servlet will not automatically know that a interceptor is present in your project : you have to create a configuration file and in that tell the dispatch servlet that there is an interceptor present in your project 
  - To do so
    1. Extend the properties of HandleInterceptor
    2. Add interseptor method to add interceptor in intercptor registry
- Interceptor has 3 methods 
  - PreHandle = In this project only this is used
  - PostHandle
  - afterCompleteHandle
- Focus on LogInterceptor class
- We check the request be using HttpServletRequest request obj getParameter method
- ⚠️Ensure "StoreCustomer".equals(CustomerId) as the checking condition not CustomerId.equals("StoreCustomer") to prevent null exception
- To write or print the response back we use getWriter from HttpServletResponse response to give/print the result back
