final class Constants {
    public static final double PI = 3.14159;

    public void showConstant() {
        System.out.println("PI value: " + PI);
    }
}

// class Derived extends Constants {} ❌ Error: Cannot inherit from final class

public class Test {
    public static void main(String[] args) {
        Constants c = new Constants();
        c.showConstant();
    }
}
