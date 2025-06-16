# 🌿 Spring MVC Form Project-3

Welcome to a **beginner-friendly Spring MVC form handling project** using JSP. This project showcases how to create and bind form data in a simple and clean Spring Boot + JSP application and store the data in the database.

---

## 📘 Table of Contents

- [🌟 Features](#-features)
- [📚 Technologies & Dependencies](#-technologies--dependencies)
- [🚀 Getting Started](#-getting-started)
- [🎯 Future Enhancements](#-future-enhancements)
- [🛠️ Project Structure](#-project-structure)
- [⚙️ Configuration Notes](#-configuration-notes)

---

## 🌟 Features

- 🗄️Same as above project just Added an extra page to show the data on a new page rather than just on db
- 📺 **Database entey shown on new page**
- 💫 Enhanced UI by students added view

---

## 📚 Technologies & Dependencies

| Tool/Library                   | Purpose                                    | Type                |
| ------------------------------ | ------------------------------------------ | ------------------- |
| `Spring Boot`                  | Base framework                             | Core Technology     |
| `Spring MVC`                   | Web MVC architecture                       | Core Technology     |
| `JSP`                          | View technology                            | Core Technology     |
| `Tomcat Embed Jasper`          | JSP rendering engine in embedded Tomcat    | External Dependency |
| `spring-boot-devtools`         | Hot reload during development              | External Dependency |
| `spring-boot-starter-web`      | Adds Spring MVC, REST, and embedded Tomcat | External Dependency |
| `spring-boot-starter-data-jpa` | Adds JPA + Hibernate ORM support           | External Dependency |
| `com.h2database:h2`            | In-memory test database                    | External Dependency |
| `javax.servlet:jstl`           | JSTL support for JSP                       | External Dependency |

## 🚀 Getting Started

### ✅ Prerequisites

- Java 8 or later
- Maven or Gradle
- IDE (Eclipse, IntelliJ, VS Code)
- Spring Data JPA
- Spring Form tags

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

4. **Access the form**

   ```
   http://localhost:8080/
   ```

5. **Access the Database**

   ```
   http://localhost:8080/h2-console
   ```

6. **view Students added in database on a new page**
   ```
   http://localhost:8080/viewStudents
   ```

[🛠️ Project Structure](#-project-structure)

```
2FormProject-2
|__src
|    |__main
|         |__java
|              |__com.form2 =>Application.java
|                    |_com.form2.Binding
|                    |_com.form2.Controller             **made changes here
|                    |_com.form2.Entity
|                    |_com.form2.Repository
|__src/main/resources =>Application.properties
|__src/test/java
|__src/main/webapp/views
|                   |_index.jsp
|                   |_data.jsp                      **added new
|__ pom.xml

```

## 🎯 Future Enhancements

1. ✅ Add Automation test cases
2. 🎨 Improve UI

## ⚙️ Configuration Notes

Ensure the packaging type is set to war, not jar, to support JSP rendering.
