public class SplitWords {
    public static void main(String[] args) {
        String sentence = "Java is simple";
        String[] words = sentence.split(" ");

        for (String word : words) {
            System.out.println(word);
        }
    }
}
