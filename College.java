import java.util.ArrayList;
import java.util.List;

public class College implements EducationalUnit {
    private String name;
    private List<EducationalUnit> components = new ArrayList<>();

    public String getName() {
    return name;
    }
    public College(String name) {
        this.name = name;
    }

    public void add(EducationalUnit unit) {
        components.add(unit);
    }

    public void remove(EducationalUnit unit) {
        components.remove(unit);
    }

    @Override
    public void print() {
        System.out.println("=== COLLEGE: " + name.toUpperCase() + " ===");
        for (EducationalUnit unit : components) {
            unit.print();
        }
    }

    @Override
    public int getNumberOfStudents() {
        int total = 0;
        for (EducationalUnit unit : components) {
            total += unit.getNumberOfStudents();
        }
        return total;
    }

    @Override
    public double getBudget() {
        double totalBudget = 0.0;
        for (EducationalUnit unit : components) {
            totalBudget += unit.getBudget();
        }
        return totalBudget;
    }
}