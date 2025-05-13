abstract class Person {
    String name;

    Person(String name) {
        this.name = name;
    }

    abstract void display();
}

class Student extends Person {
    Student(String name) {
        super(name);
    }

    void display() {
        System.out.println("Student Name: " + name);
    }
}

public class Test {
    public static void main(String[] args) {
        Student s = new Student("Ravi");
        s.display();
    }
}
