import java.util.*;

public class EmailSet {
    public static void main(String[] args) {
        HashSet<String> emails = new HashSet<>();

        emails.add("test@gmail.com");
        emails.add("user@yahoo.com");
        emails.add("test@gmail.com");  // duplicate

        for (String email : emails) {
            System.out.println(email);
        }
    }
}
