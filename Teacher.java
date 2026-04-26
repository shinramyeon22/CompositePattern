public class Teacher implements EducationalUnit {
    private String name;
    private String subject;
    private double salary;

    public Teacher(String name, String subject, double salary) {
        this.name = name;
        this.subject = subject;
        this.salary = salary;
    }

    @Override
    public void print() {
        System.out.println("   Teacher: " + name + " | Subject: " + subject + 
                          " | Salary: ₱" + String.format("%.2f", salary));
    }

    @Override
    public int getNumberOfStudents() {
        return 0;
    }

    @Override
    public double getBudget() {
        return salary;   // Teacher's budget contribution = salary
    }
}