class Base {
    public int a = 10;
    protected int b = 20;
    int c = 30;
    private int d = 40;

    static {
        System.out.println("Static Block in Base");
    }

    void display() {
        System.out.println("a=" + a + ", b=" + b + ", c=" + c);
    }
}

class Derived extends Base {
    public static void main(String[] args) {
        Derived obj = new Derived();
        obj.display();
    }
}
