interface MyInterface {
    default void greet() {
        System.out.println("Hello from default method");
    }
}

class MyClass implements MyInterface {}

public class Test {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.greet();
    }
}
