import java.util.Arrays;

public class MinSumSubarray {
    public static void main(String[] args) {
        int a[] = {1, 2, 5, 6, 7, 2};
        int k = 7;
        Arrays.sort(a);
        System.out.println(minSumSubarray(a, k));
    }

    private static int minSumSubarray(int a[], int k) {
        int r = a.length - 1;
        if (a[r] >= k) {
            return 1;
        }   
        int l = r - 1;
        int sum = 0;

        while (l > 0) {
            if (a[l] + a[r] + sum >= k) {
                return r - l + 1;
            } else {
                sum += a[l];
                l--;
            }
        }
        return 0;
    }
}
