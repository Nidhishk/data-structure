import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {8, 1, 3, 7, 2, 1, 5};
        System.out.print("Enter Target: ");
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        Arrays.sort(candidates);

        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        combinationSumHelper(candidates, target, 0, ans, new ArrayList<Integer>());
        System.out.println("Output: ");
        for (ArrayList<Integer> list : ans) {
            System.out.println(list);
        }
    }

    private static void combinationSumHelper(int[] candidates, int sum, int index, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> curr) {
        if (sum == 0) {
            ArrayList<Integer> currCopy = new ArrayList<>(curr);
            ans.add(currCopy);
        }

        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > sum) return;
            // if(i > index && candidates[i] == candidates[i-1]) continue; // To remove duplicates

            curr.add(candidates[i]);
            combinationSumHelper(candidates, sum - candidates[i], i + 1, ans, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
