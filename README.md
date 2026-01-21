# Event Management System (Console-Based Java Application)

This project is a console-based Event Management System developed in Java.  
It helps manage events, tasks, staff assignments, and task progress using a menu-driven interface.  
The application is designed with clean OOP principles, proper exception handling, and enum-based status management.

---

## 🚀 Features

- Add and manage events
- Create tasks for events
- Assign staff to tasks
- Track task status (PENDING, IN_PROGRESS, COMPLETED, DELAYED)
- Record task progress updates
- Generate event readiness summary report
- Menu-driven console interface using switch-case
- Custom exception handling for safe operations
- Enum-based task status to avoid invalid states

---

## 🛠️ Technologies Used

- Java (JDK 8+)
- Collections Framework (ArrayList, Set)
- Enum for status management
- Scanner for user input
- LocalDate for date handling
- OOP concepts (Encapsulation, Abstraction)
- Custom Exceptions

---

## 📂 Project Structure

      src/
      ├── com.wipro.ems.main
      │ └── Main.java
      │
      ├── com.wipro.ems.entity
      │ ├── Event.java
      │ ├── Task.java
      │ ├── Staff.java
      │ ├── TaskUpdate.java
      │ └── TaskStatus.java
      │
      ├── com.wipro.ems.service
      │ └── EventService.java
      │
      └── com.wipro.ems.util
      ├── TaskNotFoundException.java
      └── InvalidTaskOperationException.java


---

## 🧠 Concepts Demonstrated

- Object-Oriented Programming (OOP)
- Enum usage for controlled values
- Exception handling for business rules
- Menu-driven console application
- Data validation and safe transitions
- Separation of concerns (Entity, Service, Util)
- Real-world workflow simulation

---

## ▶️ How to Run

1. Clone the repository
   ```bash
   git clone <your-repo-url>
  Open in Eclipse / IntelliJ

  Run Main.java

   Use menu options to interact with the system

            📊 Sample Operations
            Add Event
            
            Add Task to Event
            
            Add Staff
            
            Assign Staff to Task
            
            Record Task Progress
            
            Generate Event Summary Report
            
            Exit Application

🎯 Purpose of Project
This project was built as part of an academic assignment to demonstrate:

      Java programming skills
      
      OOP design
      
      Console-based application flow
      
      Real-world problem modeling

👨‍💻 Author
Nirmaladevi S
Engineering Student | Java Developer
