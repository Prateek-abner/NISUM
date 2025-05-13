public class StaticOrder {
    static {
        System.out.println("Static Block executed first");
    }

    static void print() {
        System.out.println("Static Method executed after");
    }

    public static void main(String[] args) {
        print();
    }
}
