public class RemoveSpaces {
    public static void main(String[] args) {
        String text = "This   is   Java    Programming";
        String cleaned = text.replaceAll("\\s+", " ");
        System.out.println(cleaned);
    }
}
