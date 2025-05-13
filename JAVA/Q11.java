public class Validator {
    public static boolean isValidEmail(String email) {
        return email.contains("@") && email.contains(".");
    }

    public static boolean isValidPassword(String password) {
        return password.matches(".*[A-Za-z].*") &&
               password.matches(".*\\d.*") &&
               password.matches(".*[!@#$%^&*()].*");
    }

    public static void main(String[] args) {
        String email = "user@example.com";
        String password = "Pass123@";

        if (isValidEmail(email) && isValidPassword(password)) {
            System.out.println("Valid credentials.");
        } else {
            System.out.println("Invalid credentials.");
        }
    }
}
