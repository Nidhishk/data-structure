import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumDifference {
    public static void main(String[] args) {
        int a[] = {12, 9, 8, 2, 11, 5, 4};
        Arrays.sort(a);
        List<List<Integer>> list = minimumDiff(a);
        for (List<Integer> i : list) {
            System.out.print(i);
        }
    }

    private static List<List<Integer>> minimumDiff(int a[]) {
        List<List<Integer>> result = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < a.length; i++) {
            minDiff = Math.min(minDiff, a[i] - a[i - 1]);
        }

        for (int i = 1; i < a.length; i++) {
            if (minDiff == a[i] - a[i - 1]) {
                List<Integer> temp = new ArrayList<>();
                temp.add(a[i]);
                temp.add(a[i - 1]);
                result.add(temp);
            }
        }
        return result;
    }
}
