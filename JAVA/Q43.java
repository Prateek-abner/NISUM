public class IsDigit {
    public static void main(String[] args) {
        String str = "12345";
        boolean isOnlyDigits = str.matches("\\d+");

        System.out.println("Contains only digits? " + isOnlyDigits);
    }
}
