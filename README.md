# Student Management System - Airtribe

A **Java-based Student Management System** built with **Maven**. This project provides a simple yet extensible way to manage student records, including adding, updating, deleting, and viewing student information. It is designed as part of the Airtribe learning initiative.

---

## 🚀 Features
- **Add new students** with details like name, age, course, and ID.  
- **Update student records** dynamically.  
- **Delete students** from the system.  
- **View student list** in a structured format.  
- **Error handling** for invalid inputs and missing records.  
- Built with **Java** and managed using **Maven** for easy dependency management.

---

## 📂 Project Structure
```
Student_Management_System_Airtribe/
│── src/                # Source code
│── pom.xml             # Maven configuration
│── .gitignore          # Git ignore rules
│── mvnw, mvnw.cmd      # Maven wrapper scripts
│── .mvn/wrapper        # Maven wrapper files
```

---

## ⚙️ Installation & Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/Shreyash0411/Student_Management_System_Airtribe.git
   cd Student_Management_System_Airtribe
   ```

2. **Build the project with Maven**
   ```bash
   mvn clean install
   ```

3. **Run the application**
   ```bash
   mvn exec:java
   ```

---

## 🧑‍💻 Usage

When you run the program, you’ll see a **menu-driven interface** like this:

```
===== Student Management System =====
1. Add Student
2. Update Student
3. Delete Student
4. View Students
5. Exit
Enter your choice:
```

### Example Workflow

**Adding a Student**
```
Enter Student ID: 101
Enter Student Name: Alice
Enter Student Age: 20
Enter Student Course: Computer Science
Student added successfully!
```

**Viewing Students**
```
===== Student List =====
ID: 101 | Name: Alice | Age: 20 | Course: Computer Science
```

**Updating a Student**
```
Enter Student ID to update: 101
Enter new name: Alicia
Enter new age: 21
Enter new course: Data Science
Student updated successfully!
```

**Deleting a Student**
```
Enter Student ID to delete: 101
Student deleted successfully!
```

---

## 📖 Technologies Used
- **Java 17+**  
- **Maven** for build automation  
- **OOP principles** for modular design  

---

## 🤝 Contributing
Contributions are welcome!  
1. Fork the repo  
2. Create a new branch (`feature-xyz`)  
3. Commit changes  
4. Open a Pull Request  

---

## 📜 License
This project is licensed under the MIT License. You are free to use, modify, and distribute it.

---

## 👤 Author
- **Shreyash0411**  
  GitHub: [Shreyash0411](https://github.com/Shreyash0411)

---

✨ This demo makes the README much more approachable for beginners. Would you like me to also add a **Future Enhancements** section (e.g., database integration, GUI, REST API) so contributors know where the project could grow?
