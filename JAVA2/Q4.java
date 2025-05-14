import java.util.*;

public class Inventory {
    public static void main(String[] args) {
        HashMap<String, Integer> stock = new HashMap<>();

        stock.put("Pen", 50);
        stock.put("Book", 20);

        stock.put("Pen", 100); // update

        System.out.println("Pen in stock: " + stock.get("Pen"));

        stock.remove("Book");

        System.out.println("Book in stock: " + stock.get("Book"));
    }
}
