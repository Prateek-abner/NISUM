class Parent {
    void show() {
        System.out.println("Parent method");
    }
}

class Child extends Parent {
    void display() {
        System.out.println("Child method");
    }
}

public class Test {
    public static void main(String[] args) {
        Parent p = new Child();
        p.show(); // ✅ Allowed
        // p.display(); ❌ Not allowed directly
    }
}
