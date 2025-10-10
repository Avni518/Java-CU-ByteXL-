import java.util.ArrayList;
import java.util.List;

class Employee {
    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Salary: " + salary;
    }
}

public class PartA {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 30, 75000));
        employees.add(new Employee("Bob", 25, 50000));
        employees.add(new Employee("Charlie", 28, 60000));
        employees.add(new Employee("David", 35, 80000));

        System.out.println("Original List:");
        employees.forEach(System.out::println);

        employees.sort((e1, e2) -> e1.getName().compareTo(e2.getName()));
        System.out.println("\nSorted by Name:");
        employees.forEach(System.out::println);

        employees.sort((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()));
        System.out.println("\nSorted by Age:");
        employees.forEach(System.out::println);

        employees.sort((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()));
        System.out.println("\nSorted by Salary (Descending):");
        employees.forEach(System.out::println);
    }
}

