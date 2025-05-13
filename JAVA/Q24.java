interface MyInterface {
    static void greet() {
        System.out.println("Hello from static interface method");
    }
}

public class Test {
    public static void main(String[] args) {
        MyInterface.greet(); // Call via interface name
    }
}
