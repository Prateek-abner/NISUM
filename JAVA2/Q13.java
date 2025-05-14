import java.util.*;

public class CommonElements {
    public static List<Integer> getCommon(List<Integer> a, List<Integer> b) {
        List<Integer> result = new ArrayList<>();
        for (int n : a) {
            if (b.contains(n) && !result.contains(n))
                result.add(n);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(3, 4, 5, 6);
        System.out.println(getCommon(list1, list2));
    }
}
