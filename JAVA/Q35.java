public class Person {
    String name;

    Person(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Person p1 = new Person("Ravi");
        Person p2 = new Person("Ravi");

        System.out.println("toString: " + p1.toString());
        System.out.println("hashCode: " + p1.hashCode());
        System.out.println("equals: " + p1.equals(p2));
    }
}
