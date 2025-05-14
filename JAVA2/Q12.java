import java.util.*;

public class UniqueSorted {
    public static Set<Integer> getSortedUnique(int[] arr) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int n : arr) set.add(n);
        return set;
    }

    public static void main(String[] args) {
        int[] nums = {5, 3, 8, 3, 5, 1};
        System.out.println(getSortedUnique(nums));
    }
}
