public class OverloadDemo {
    void show() {
        System.out.println("No parameter");
    }

    void show(String name) {
        System.out.println("Hello " + name);
    }

    void show(int num) {
        System.out.println("Number: " + num);
    }

    public static void main(String[] args) {
        OverloadDemo obj = new OverloadDemo();
        obj.show();
        obj.show("Raj");
        obj.show(100);
    }
}
