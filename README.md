# 🎓 New Era University — Composite Design Pattern

![Java](https://img.shields.io/badge/Java-17%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Pattern](https://img.shields.io/badge/Design%20Pattern-Composite-4A90D9?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Complete-2ECC71?style=for-the-badge)

> A Java implementation of the **Composite Design Pattern** modeling the hierarchical organizational structure of New Era University — Colleges, Departments, Teachers, and Students.

## 📐 UML Class Diagram

`````mermaid
classDiagram
    class EducationalUnit {
        <<interface>>
        +print() void
        +getNumberOfStudents() int
        +getBudget() double
    }

    class College {
        -name: String
        -components: List~EducationalUnit~
        +getName() String
        +add(unit: EducationalUnit) void
        +remove(unit: EducationalUnit) void
        +print() void
        +getNumberOfStudents() int
        +getBudget() double
    }

    class Department {
        -name: String
        -components: List~EducationalUnit~
        +getName() String
        +add(unit: EducationalUnit) void
        +remove(unit: EducationalUnit) void
        +print() void
        +getNumberOfStudents() int
        +getBudget() double
    }

    class Teacher {
        -name: String
        -subject: String
        -salary: double
        +print() void
        +getNumberOfStudents() int
        +getBudget() double
    }

    class Student {
        -name: String
        -studentId: String
        -tuitionFee: double
        +print() void
        +getNumberOfStudents() int
        +getBudget() double
    }

    EducationalUnit <|.. College : implements
    EducationalUnit <|.. Department : implements
    EducationalUnit <|.. Teacher : implements
    EducationalUnit <|.. Student : implements
    College o-- EducationalUnit : has-a (List)
    Department o-- EducationalUnit : has-a (List)
` `` 
`````

> ⚠️ Remove the space in the last ` `` ` — that's just to avoid breaking this message.

---

**3. Project Structure**
`````markdown
## 📁 Project Structure

`````
lab-assignment-8/
│
├── EducationalUnit.java     # Component interface
├── College.java             # Composite — holds any EducationalUnit
├── Department.java          # Composite — holds Teachers & Students
├── Teacher.java             # Leaf — individual instructor
├── Student.java             # Leaf — individual student
└── UniversityDemo.java      # Client / entry point
` ``

## 🧩 Pattern Breakdown

| Role | Class | Description |
|------|-------|-------------|
| **Component** | `EducationalUnit` | Interface defining the shared contract for all units |
| **Composite** | `College` | Contains Departments, Teachers, Students, or other Colleges |
| **Composite** | `Department` | Contains Teachers and Students |
| **Leaf** | `Teacher` | Individual entity; `getBudget()` returns salary |
| **Leaf** | `Student` | Individual entity; `getBudget()` returns `-tuitionFee` |

### Budget Logic
College Budget    = Σ(Department budgets) + Σ(Teacher salaries) − Σ(Student tuition fees)
Department Budget = Σ(Teacher salaries) − Σ(Student tuition fees)
Teacher Budget    = salary
Student Budget    = −tuitionFee
` ``

---

**5. How to Run**
`````markdown
## 🚀 How to Run

### Prerequisites
- Java 17 or higher
- Any Java IDE or terminal

### Compile
````bash
javac *.java
` ``

### Run
```bash
java UniversityDemo
` ``
```

---

**6. Sample Output**
```markdown
## 📋 Sample Output

```
UNIVERSITY ORGANIZATION STRUCTURE:

=== COLLEGE: COLLEGE OF ENGINEERING ===
--- DEPARTMENT: COMPUTER SCIENCE ---
   Teacher: Dr. Elena Garcia | Subject: Data Structures | Salary: ₱85000.00
   Teacher: Prof. Michael Chen | Subject: Algorithms | Salary: ₱92000.00
   Student: Alice Johnson (ID: 2023-001) | Tuition: ₱45000.00
   Student: Bob Smith (ID: 2023-002) | Tuition: ₱42000.00
--- DEPARTMENT: INFORMATION TECHNOLOGY ---
   Teacher: Dr. Sarah Lopez | Subject: Database Systems | Salary: ₱78000.00
   Student: Carol Williams (ID: 2023-003) | Tuition: ₱48000.00
   Student: David Brown (ID: 2023-004) | Tuition: ₱43000.00
   Student: Eve Davis (ID: 2023-005) | Tuition: ₱46000.00

============================================================
TOTAL STUDENTS IN College (College of Engineering): 5
TOTAL BUDGET FOR College: ₱71000.00
` ``
````

---

**7. Key Design Decisions + Author**
````markdown
## 💡 Key Design Decisions

**Why the Composite Pattern?**
The university hierarchy is a classic part-whole relationship. The Composite pattern lets you call `getBudget()` or `getNumberOfStudents()` on any node — leaf or composite — and get the correct recursive result without the client needing to know the type.

**Why is Student's budget negative?**
Tuition fees reduce the net operational budget. `Student.getBudget()` returns `-tuitionFee`, and composites simply sum their children.

**Why can College hold any `EducationalUnit` directly?**
Flexibility — a student or teacher can be assigned directly to a college without belonging to a specific department.

---


