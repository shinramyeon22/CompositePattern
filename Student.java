public class Student implements EducationalUnit {
    private String name;
    private String studentId;
    private double tuitionFee;

    public Student(String name, String studentId, double tuitionFee) {
        this.name = name;
        this.studentId = studentId;
        this.tuitionFee = tuitionFee;
    }

    @Override
    public void print() {
        System.out.println("   Student: " + name + " (ID: " + studentId + 
                          ") | Tuition: ₱" + String.format("%.2f", tuitionFee));
    }

    @Override
    public int getNumberOfStudents() {
        return 1;
    }

    @Override
    public double getBudget() {
        return -tuitionFee;   // Student contributes negative to budget
    }
}