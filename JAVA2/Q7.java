import java.util.*;

public class WordCount {
    public static void main(String[] args) {
        String text = "hello world hello java";

        String[] words = text.toLowerCase().split(" ");

        HashMap<String, Integer> map = new HashMap<>();

        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        for (String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }
    }
}
