import java.util.ArrayList;
import java.util.List;

public class ThreeSumProblem {
    public static void main(String[] args) {
        int a[] = {4, 2, 2, 2, 1, 1, 1, -1, -3, 0, 1, 2, 3, 3, 3};
        int sum = 4;
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < a.length - 2; i++) {
            if (i > 0 && a[i] == a[i - 1]) continue;
            List<List<Integer>> temp = twoSum(a, -a[i], 0);
            for(List<Integer> list : temp) {
                list.add(0, a[i]);
                ans.add(list);
            }
        }
        System.out.println(ans);
    }

    private static List<List<Integer>> twoSum(int a[], int sum, int startsFrom) {
        int l = startsFrom;
        int r = a.length - 1;
        List<List<Integer>> result = new ArrayList<>();

        while (l < r) {
            if (l > startsFrom && a[l] == a[l - 1]) {
                l++;
                continue;
            }
            if (r < a.length - 1 && a[r] == a[r + 1]) {
                r--;
                continue;
            }

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

/*
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // crucial

        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // skip dup anchors

            int l = i + 1, r = n - 1, target = -nums[i];
            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum < target) {
                    l++;
                } else if (sum > target) {
                    r--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++; r--;
                    while (l < r && nums[l] == nums[l - 1]) l++; // skip dup left
                    while (l < r && nums[r] == nums[r + 1]) r--; // skip dup right
                }
            }
        }
        return result;
    }
}
*/
