public class ArrayPermutation {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        permute(arr, 0, arr.length - 1);
    }

    private static void permute(int arr[], int l, int r) {
        if (l == r) {
            printArray(arr);
            return;
        }

        for (int i = l; i <= arr.length - 1; i++) {
            swap(arr, i, l);
            permute(arr, l + 1, r);
            swap(arr, i, l);    // For Backtracking, which retain the original array
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void printArray(int[] arr) {
        for (int a : arr) {
            System.out.print(a);
        }
        System.out.println();
    }
}
