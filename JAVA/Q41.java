import java.util.*;

public class CharCount {
    public static void main(String[] args) {
        String str = "Super Man Bat Man Spider Man".replaceAll(" ", "").toLowerCase();
        Map<Character, Integer> map = new HashMap<>();

        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (var entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
