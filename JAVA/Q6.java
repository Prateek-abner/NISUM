class Parent {
    static void hello() {
        System.out.println("Hello from Parent");
    }
}

class Child extends Parent {
    public static void main(String[] args) {
        hello(); // from Parent
    }
}
