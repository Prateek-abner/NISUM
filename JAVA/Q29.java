class A {
    final void show() {
        System.out.println("Final method - can't override");
    }
}

class B extends A {
    // void show() {} ❌ Error: Cannot override final method
}

public class Test {
    public static void main(String[] args) {
        new B().show();
    }
}
