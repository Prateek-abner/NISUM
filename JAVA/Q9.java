public class Student {
    String name;
    String section;
    static String college = "ABC College";
    static int rollCount = 1;
    int rollNo;

    Student(String name, String section) {
        this.name = name;
        this.section = section;
        this.rollNo = rollCount++;
    }

    void showInfo() {
        System.out.println("Name: " + name);
        System.out.println("Section: " + section);
        System.out.println("College: " + college);
        System.out.println("Roll No: " + rollNo);
    }

    public static void main(String[] args) {
        Student s1 = new Student("Anu", "A");
        Student s2 = new Student("Manu", "B");

        s1.showInfo();
        System.out.println("-----");
        s2.showInfo();
    }
}
