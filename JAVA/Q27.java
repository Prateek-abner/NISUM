@FunctionalInterface
interface Calculator {
    int operation(int a, int b);
}

public class Test {
    public static void main(String[] args) {
        Calculator add = (a, b) -> a + b;
        System.out.println("Sum: " + add.operation(10, 20));
    }
}
