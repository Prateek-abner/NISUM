import java.util.*;

class Student {
    int id;
    String name;
    int grade;

    Student(int id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public String toString() {
        return id + " - " + name + " - Grade: " + grade;
    }
}

public class StudentList {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();

        list.add(new Student(1, "John", 90));
        list.add(new Student(2, "Sara", 85));

        for (Student s : list) {
            System.out.println(s);
        }
    }
}
