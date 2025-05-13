public class StaticExample {
    static {
        System.out.println("Static Block Runs First");
    }

    public static void main(String[] args) {
        System.out.println("Main Method Runs After");
    }
}
