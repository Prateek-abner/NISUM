import java.util.*;

public class Browser {
    public static void main(String[] args) {
        Stack<String> history = new Stack<>();

        history.push("google.com");
        history.push("youtube.com");

        System.out.println("Current: " + history.peek());

        history.pop(); // go back

        System.out.println("Now: " + history.peek());
    }
}
