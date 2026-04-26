public class UniversityDemo {
    public static void main(String[] args) {
        
        // Create Students
        Student s1 = new Student("Alice Johnson", "2023-001", 45000);
        Student s2 = new Student("Bob Smith", "2023-002", 42000);
        Student s3 = new Student("Carol Williams", "2023-003", 48000);
        Student s4 = new Student("David Brown", "2023-004", 43000);

        // Create Teachers
        Teacher t1 = new Teacher("Dr. Elena Garcia", "Data Structures", 85000);
        Teacher t2 = new Teacher("Prof. Michael Chen", "Algorithms", 92000);
        Teacher t3 = new Teacher("Dr. Sarah Lopez", "Database Systems", 78000);

        // Create Departments
        Department csDept = new Department("Computer Science");
        csDept.add(t1);
        csDept.add(t2);
        csDept.add(s1);
        csDept.add(s2);

        Department itDept = new Department("Information Technology");
        itDept.add(t3);
        itDept.add(s3);
        itDept.add(s4);

        // Create College
        College engineering = new College("College of Engineering");
        engineering.add(csDept);
        engineering.add(itDept);

        // Add a direct student to College (demonstrating flexibility)
        Student s5 = new Student("Eve Davis", "2023-005", 46000);
        engineering.add(s5);

        // Display Details
        System.out.println("UNIVERSITY ORGANIZATION STRUCTURE:\n");
        engineering.print();

        // Calculate and Display Total Students
        System.out.println("\n" + "=".repeat(60));
        System.out.println("TOTAL STUDENTS IN " + engineering.getClass().getSimpleName() + 
                          " (" + engineering.getName() + "): " + 
                          engineering.getNumberOfStudents());

        // Calculate and Display Budget
        System.out.println("TOTAL BUDGET FOR " + engineering.getClass().getSimpleName() + 
                          ": ₱" + String.format("%.2f", engineering.getBudget()));
    }
}

// Helper method to get name (optional, or you can add getName() to interface)