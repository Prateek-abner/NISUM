import java.util.*;

class Product {
    String name, category;
    double price;

    Product(String n, String c, double p) {
        name = n; category = c; price = p;
    }

    public String toString() {
        return category + " | " + name + " | $" + price;
    }
}

public class ProductSort {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
        list.add(new Product("Shirt", "Clothes", 20));
        list.add(new Product("Jeans", "Clothes", 40));
        list.add(new Product("Soap", "Toiletries", 5));
        list.add(new Product("Shampoo", "Toiletries", 10));

        list.sort(Comparator.comparing((Product p) -> p.category)
                            .thenComparing(p -> p.price));

        for (Product p : list) {
            System.out.println(p);
        }
    }
}
