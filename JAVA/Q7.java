public class StaticFlow {
    static int number = 10;

    static {
        System.out.println("Static Block Called!");
        number = 20;
    }

    public static void main(String[] args) {
        System.out.println("Main Method");
        System.out.println("Number: " + number);
    }
}
