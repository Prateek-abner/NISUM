public class StaticAccess {
    int num = 100;

    static void display() {
        // System.out.println(num); // ❌ Error - Cannot access instance variable directly
        System.out.println("Static methods can't access instance variables directly.");
    }

    public static void main(String[] args) {
        display();
    }
}
