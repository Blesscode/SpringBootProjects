# 🌿 Spring MVC Form Validation Project-5 **THYMELEAF**

Welcome to a **beginner-friendly Spring MVC form handling project** using **thymeleaf**. This project showcases how to validate form feilds in a form.

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

- Validates form fields in a thymeleaf form project
- Shows how to validate [textboxes, dropdown, checkbox, radio button]
- Utilises thymeleaf validation dependency to perform validation
- If not verified shows message next to the respective field
- Eg. Textbox should not be empty, atleast one of the checkboxes should be checked etc.
- Need to handle changes in 1)Html page 2) Binding class 3) Controller class

---

## 📚 Technologies & Dependencies

| Tool/Library              | Purpose                                    | Type                |
| ------------------------- | ------------------------------------------ | ------------------- |
| `Spring Boot`             | Base framework                             | Core Technology     |
| `Spring MVC`              | Web MVC architecture                       | Core Technology     |
| `Thymeleaf`               | View technology                            | External Dependency |
| `spring-boot-devtools`    | Hot reload during development              | External Dependency |
| `spring-boot-starter-web` | Adds Spring MVC, REST, and embedded Tomcat | External Dependency |
| `thymeleaf-validation`    | To perform validation (brings with it @NotNull,@NotEmpty,@Size,@Valid,ResultBinding(I) | External Dependency |


## 🚀 Getting Started

### ✅ Prerequisites

- Java 8 or later
- Maven or Gradle
- IDE (Eclipse, IntelliJ, VS Code)
- Thymleaf form 
- Thymeleaf validation 

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

[🛠️ Project Structure](#-project-structure)

```
6Form Validation 
|__src
|    |__main
|         |__java
|              |__com.form =>Application.java
|                    |_com.form.Binding
|                    |_com.form.Controller
|                    |_com.form.Entity
|                    |_com.form.Repository
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
- Binding
  - String : @NotEmpty , @Size
  - Integer : @NotNull
  - for regular expression : @Pattern
- HTML
  - th:feilds("${feild.hasError({'name'})}") : to check the feild for error
  -  th:errors("*{'name'}) : to place the value of variable as error
- Controller
   - BindingResult : to check if the result has any error
   - @valid : to check if binding class objects validation condition are fulfilled or not
