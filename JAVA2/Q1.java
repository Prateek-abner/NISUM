import java.util.*;

class Item {
    String name;
    double price;
    int qty;

    Item(String name, double price, int qty) {
        this.name = name;
        this.price = price;
        this.qty = qty;
    }

    public String toString() {
        return name + " - $" + price + " x " + qty;
    }
}

public class ShoppingCart {
    public static void main(String[] args) {
        ArrayList<Item> cart = new ArrayList<>();

        cart.add(new Item("Apple", 1.5, 3));
        cart.add(new Item("Bread", 2.0, 2));

        for (Item i : cart) {
            System.out.println(i);
        }

        double total = 0;
        for (Item i : cart) {
            total += i.price * i.qty;
        }

        System.out.println("Total: $" + total);
    }
}
