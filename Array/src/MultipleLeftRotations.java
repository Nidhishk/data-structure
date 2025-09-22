public class MultipleLeftRotations {
    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5};
        int k = 3;
        rotateByK(a, k);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    private static void rotateByK(int a[], int k) {
        int n = a.length;
        for (int i = 0; i < k; i++) {
            int temp = a[0];
            for (int j = 0; j < n - 1; j++) {
                a[j] = a[j + 1];
            }
            a[n - 1] = temp;
        }
    }
}
// Time Complexity :: [O(k*n)*m]