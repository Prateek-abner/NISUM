public class UserDetails {
    public String name = "Raj";
    public int id = 101;
    public String email = "raj@example.com";
    private String creditCard = "1234-5678-9012-3456";
    private double balance = 5000.0;

    public static void main(String[] args) {
        UserDetails user = new UserDetails();

        System.out.println("Name: " + user.name);
        System.out.println("ID: " + user.id);
        System.out.println("Email: " + user.email);
        // Cannot access creditCard or balance here (private)
    }
}
