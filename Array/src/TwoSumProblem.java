import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Solve using 2 pointer Algorithm
public class TwoSumProblem {
    public static void main(String[] args) {
        int a[] = {4, 2, -1, -3, 0, 1, 2, 3};
        int sum = 4;
        Arrays.sort(a); //  {-3, -1, 0, 1, 2, 3, 4}
        System.out.println(twoSum(a, sum, 0));
    }

    private static List<List<Integer>> twoSum(int a[], int sum, int startsFrom) {
        int l = startsFrom;
        int r = a.length - 1;
        List<List<Integer>> result = new ArrayList<>();

        while (l < r) {
            if (a[l] + a[r] > sum) {
                r--;
            } else if (a[l] + a[r] < sum) {
                l++;
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(a[l]);
                temp.add(a[r]);
                result.add(temp);
                l++;
                r--;
            }
        }
        return result;
    }
}
