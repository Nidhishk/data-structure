/**
 * Check if an array is sorted (Strictly Increasing)
 */
public class CheckSortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(isSortedArray(arr, 0));
    }

    public static boolean isSortedArray(int[] arr, int idx) {
        if (idx == arr.length - 1) {
            return true;
        }

        if (arr[idx] > arr[idx + 1]) {
            // array is unsorted till now
            return false;
        } else {
            return isSortedArray(arr, idx + 1);
        }
    }
}