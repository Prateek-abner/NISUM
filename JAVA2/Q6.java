import java.util.*;

class Employee implements Comparable<Employee> {
    String name;
    Employee(String name) {
        this.name = name;
    }
    public int compareTo(Employee e) {
        return name.compareTo(e.name);
    }
    public String toString() {
        return name;
    }
}

public class EmpRecords {
    public static void main(String[] args) {
        TreeSet<Employee> set = new TreeSet<>();
        set.add(new Employee("Zara"));
        set.add(new Employee("Alice"));
        set.add(new Employee("Mike"));

        for (Employee e : set) {
            System.out.println(e);
        }
    }
}
