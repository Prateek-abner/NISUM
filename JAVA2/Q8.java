import java.util.*;

class MenuItem {
    String name;
    double price;

    MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String toString() {
        return name + " - $" + price;
    }
}

public class MenuSystem {
    public static void main(String[] args) {
        LinkedHashMap<String, ArrayList<MenuItem>> menu = new LinkedHashMap<>();

        menu.put("Appetizer", new ArrayList<>());
        menu.put("Main", new ArrayList<>());

        menu.get("Appetizer").add(new MenuItem("Fries", 3.5));
        menu.get("Main").add(new MenuItem("Burger", 7.0));

        for (String category : menu.keySet()) {
            System.out.println(category + ":");
            for (MenuItem item : menu.get(category)) {
                System.out.println(" - " + item);
            }
        }
    }
}
