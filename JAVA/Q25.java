class Outer {
    interface Inner {
        void show();
    }
}

class Test implements Outer.Inner {
    public void show() {
        System.out.println("Nested interface implemented.");
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.show();
    }
}
