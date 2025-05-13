class Nisum {
    String company = "Nisum Technologies";
}

class Employee extends Nisum {
    void showCompany() {
        System.out.println("Company: " + company); // inherited
    }

    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.showCompany();
    }
}
