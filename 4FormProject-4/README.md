# 🌿 Spring MVC Form Project-4 **THYMELEAF**

Welcome to a **beginner-friendly Spring MVC form handling project** using **thymeleaf**. This project showcases how to create a simple form and it's main purpose is to make famaliar with how thymeleaf works.

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

- Thyemelaf used
- provide advanced features compared to jsp
- makes html dyanmic with thymeleaf
- instead of the /views folder, presentation files are saved inside the /templates folder
- No setup required as for view in application.properties for template files

---

## 📚 Technologies & Dependencies

| Tool/Library              | Purpose                                    | Type                |
| ------------------------- | ------------------------------------------ | ------------------- |
| `Spring Boot`             | Base framework                             | Core Technology     |
| `Spring MVC`              | Web MVC architecture                       | Core Technology     |
| `Thymeleaf`               | View technology                            | External Dependency |
| `spring-boot-devtools`    | Hot reload during development              | External Dependency |
| `spring-boot-starter-web` | Adds Spring MVC, REST, and embedded Tomcat | External Dependency |

## 🚀 Getting Started

### ✅ Prerequisites

- Java 8 or later
- Maven or Gradle
- IDE (Eclipse, IntelliJ, VS Code)
- How Spring Form works
- Thymeleaf

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
2FormProject-2
|__src
|    |__main
|         |__java
|              |__com.form2 =>Application.java
|                    |_com.form2.Binding
|                    |_com.form2.Controller
|                    |_com.form2.Entity
|                    |_com.form2.Repository
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
- The model is added automatically if the object added in the form has same name as the binding object inside post else(eg. student used here) have to added manually or use @ModelAttribute("student")
  ```
  @PostMapping("/save")
  public String saveDataOfForm(@ModelAttribute("student") User user, Model model) {
      model.addAttribute("msg", "User data saved");
      return "index";
  }
  ```
- Symbols used

  - `*` = feilds mapping to binding object class {note the names same as per binding object class}
  - `$` = used for adding binding object to form {note the name can be any but when model added make shure the name is same and the value is user object i.e. binding object}
  - `@` = used for action performed when form submit

- Compared to previous projects here we pass an empty binding object in the form initially that why we perform

  ```
  - Inside "/"

  modle.addAttribute("binding object name","create binding object and pass it here")

  ```
