import java.util.ArrayList;
import java.util.List;

class Student {
    private String name;
    private double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Marks: " + marks;
    }
}

public class PartB {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 82));
        students.add(new Student("Bob", 70));
        students.add(new Student("Charlie", 90));
        students.add(new Student("David", 65));
        students.add(new Student("Eve", 78));

        System.out.println("Students scoring above 75% sorted by marks:");
        students.stream()
                .filter(s -> s.getMarks() > 75)
                .sorted((s1, s2) -> Double.compare(s1.getMarks(), s2.getMarks()))
                .map(Student::getName)
                .forEach(System.out::println);
    }
}
