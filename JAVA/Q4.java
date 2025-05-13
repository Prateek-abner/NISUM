public class Cart {
    String itemName;
    int itemId;
    double itemPrice;

    Cart(String name, int id, double price) {
        itemName = name;
        itemId = id;
        itemPrice = price;
    }

    public static void main(String[] args) {
        Cart item1 = new Cart("Pen", 101, 10.0);
        Cart item2 = new Cart("Notebook", 102, 50.0);

        int itemsCount = 2;
        double total = item1.itemPrice + item2.itemPrice;

        System.out.println("Items in Cart: " + itemsCount);
        System.out.println("Total Price: Rs. " + total);
    }
}
