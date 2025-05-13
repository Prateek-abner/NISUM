public class SplitExample {
    public static void main(String[] args) {
        String line = "apple,banana,grapes";
        String[] fruits = line.split(",");

        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}
