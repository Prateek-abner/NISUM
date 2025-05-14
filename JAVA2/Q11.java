import java.util.*;

public class SimpleStack {
    public static void main(String[] args) {
        ArrayDeque<String> stack = new ArrayDeque<>();

        stack.push("Page1");
        stack.push("Page2");

        System.out.println("Top: " + stack.peek());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Now Top: " + stack.peek());
    }
}
