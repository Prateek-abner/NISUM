class Vehicle {
    String brand = "Tata";
}

class Car extends Vehicle {
    void display() {
        System.out.println("Car brand: " + brand);
    }
}

class Bus extends Vehicle {
    void display() {
        System.out.println("Bus brand: " + brand);
    }
}

public class Transport {
    public static void main(String[] args) {
        new Car().display();
        new Bus().display();
    }
}
