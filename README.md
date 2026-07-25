# Student Management System (Core Java)

A robust, console-based **Student Management System** built using Core Java. This project demonstrates advanced Object-Oriented Programming (OOP) principles, the Collections Framework (`HashMap`), File Handling (Serialization), Custom Exceptions, and the Java Streams API.

---

## 🚀 Features & Enhancements

* **CRUD Operations**: Seamlessly Add, View, Update, Remove, and Search student records.
* **Optimized Data Structures**: Utilizes `HashMap<Integer, Student>` for lightning-fast $O(1)$ lookups, updates, and deletions by Student ID.
* **Permanent Data Persistence**: Implements **Java IO Serialization** (`ObjectOutputStream` / `ObjectInputStream`) to save and load student data automatically from `students_data.txt`, ensuring no data loss across application restarts[cite: 14, 16].
* **Modern Java Streams API**: 
  * Automatically sorts and displays students in a **Merit List** based on their percentages in descending order[cite: 15, 16].
  * Filters and searches student records efficiently[cite: 15, 16].
* **Robust Exception Handling**: 
  * Built-in protection against invalid user inputs (`InputMismatchException`)[cite: 5, 16].
  * **Custom Exceptions** (`StudentNotFoundException`, `InvalidAgeException`) to gracefully manage business logic errors, such as invalid age entries or non-existent IDs[cite: 7, 13, 16].
* **Automated Calculations**: Automatically computes percentages, academic grades (A+ to F), and pass/fail results based on entered course marks[cite: 5, 16].

---

## 🛠️ Tech Stack & Concepts

* **Language**: Java (Core Java / JDK)[cite: 16]
* **Key Concepts**: 
  * Collections Framework (`HashMap`, `ArrayList`)[cite: 9, 16]
  * Java IO & Serialization[cite: 9, 16]
  * Java 8+ Streams API & Lambdas[cite: 16]
  * Exception Handling (Custom & Built-in Exceptions)[cite: 7, 13, 16]
  * Object-Oriented Programming (Encapsulation, Separation of Concerns)

---

## 📁 Project Structure

```text
Student-Management-System/
│
├── Student.java                  # Entity class representing student attributes (implements Serializable)[cite: 9]
├── StudentService.java           # Business logic layer (CRUD, File IO, Streams, HashMap)[cite: 16]
├── StudentManagementSystem.java  # Main execution class with console menu interface[cite: 11]
├── StudentNotFoundException.java # Custom exception for missing student records[cite: 13]
├── InvalidAgeException.java      # Custom exception for invalid age validation[cite: 7]
└── students_data.txt             # Serialized file for permanent data storage[cite: 14, 16]


⚙️ How to Run the Project
Clone or Download this repository/folder to your local machine.

Open your terminal or IDE (such as IntelliJ IDEA or Eclipse) in the project directory.

Compile all Java files:

Bash
javac *.java
Run the main application:

Bash
java StudentManagementSystem
💡 Future Scope
Migrating data persistence from File Handling to a Relational Database (MySQL) using JDBC.

Upgrading the application into a full-stack web application using Spring Boot and an HTML/CSS/JavaScript frontend.
