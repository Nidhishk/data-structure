public class MultipleLeftRotationOptimize {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 3};
        int[][] ans = new int[b.length][a.length];
        rotateByK(a, b, ans);

        for (int[] e : ans) {
            for(int x : e) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

    private static void rotateByK(int[] a, int[] b, int[][] ans) {
        int n = a.length;
        int m = b.length;
        int[] temp = new int[2 * n];

        for (int i = 0; i < n; i++) {
            temp[i] = a[i];
            temp[i + n] = a[i];
        }

        for (int i = 0; i < m; i++) {
            int k = b[i] % n;
            for (int j = 0; j < n; j++) {
                ans[i][j] = temp[j + k];
            }
        }
    }
}
