class Student {
    public String name = "Ravi";
    private int math = 90;
    private int science = 85;
    private int english = 88;
    private String college = "XYZ College";

    public void showData() {
        System.out.println("Name: " + name);
        System.out.println("College: " + college);
        System.out.println("Total Marks: " + (math + science + english));
    }
}

public class Main {
    public static void main(String[] args) {
        Student s = new Student();
        s.showData();
    }
}
