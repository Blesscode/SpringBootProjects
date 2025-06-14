# 🌿 Spring MVC Form Project

Welcome to a **beginner-friendly Spring MVC form handling project** using JSP. This project showcases how to create and bind form data in a simple and clean Spring Boot + JSP application.

---

## 📘 Table of Contents

- [🌟 Features](#-features)
- [📚 Technologies Used](#-technologies-used)
- [🔌 External Dependencies Used](#-external-dependencies-used)
- [🚀 Getting Started](#-getting-started)
- [🧠 Key Concepts](#-key-concepts)
- [🛠 Project Structure](#-project-structure)
- [🎯 Future Enhancements](#-future-enhancements)
- [⚙️ Configuration Notes](#-configuration-notes)

---

## 🌟 Features

- 📄 Simple JSP-based form
- ⚙️ Spring MVC architecture
- 🔗 Automatic data binding to Java objects(speciality of spring mvc)
- 💡 Easy to understand for beginners
- 🔁 Supports WAR packaging for servlet compatibility

---

## 📚 Technologies Used

| Tool/Library           | Purpose                        |
| ---------------------- | ------------------------------ |
| `Spring Boot`          | Base framework                 |
| `Spring MVC`           | Web MVC architecture           |
| `JSP`                  | View technology                |
| `Tomcat Embed Jasper`  | JSP rendering engine           |
| `spring-boot-devtools` | Live reload during development |

---

### 🔌 External Dependencies Used

spring-boot-starter-web – Provides Spring MVC, embedded Tomcat, and REST support.

spring-boot-devtools – Enables hot swapping and automatic restart.

tomcat-embed-jasper – Enables JSP compilation in embedded Tomcat.

## 🚀 Getting Started

### ✅ Prerequisites

- Java 8 or later
- Maven or Gradle
- IDE (Eclipse, IntelliJ, VS Code)

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

## 🧠 Key Concepts

1. 🔁 Controllers
   Controllers handle incoming HTTP requests from Diapatcher Servlet and return responses using ModelAndView objects. They act as a bridge between the view (JSP) and the model (Java object).

2. 🔗 Binding
   Spring MVC supports automatic binding of form data to Java objects. You don’t have to manually extract form parameters — Spring does it for you!

## 🛠 Project Structure

        ```none
        1FormProject/
        ├── src/
        │   └── main/
        │   |   ├── java/
        │   |   │   ├── com/
        │   |   │   │   └── form/
        │   |   │   │       ├── controller/       # Controller classes
        │   |   │   │       └── binding/          # Binding model classes
        │   |   │   │       └── Application.java  # Starter class
        │   |   ├── resources/
        │   |   │   └── application.properties    # Spring config
        │   |   └── webapp/
        │   |       └── views/                    # JSP views
        │   └── test/
        ├── pom.xml                               # Maven build file
        ```

## 🎯 Future Enhancements

1. ✅ Add Automation test cases
2. 🎨 Improve UI

## ⚙️ Configuration Notes

Ensure the packaging type is set to war, not jar, to support JSP rendering.
