import java.util.Arrays;

public class MakeMatrixEqual {
    public static void main(String[] args) {
        int a[][] = {
                {3, 63, 42},
                {18, 12, 12},
                {15, 21, 18},
                {33, 84, 24}
        };
        int k = 3;
        System.out.println(makeMatrixEqual(a, k));
    }

    private static int makeMatrixEqual(int[][] a, int k) {
        int n = a.length;
        if (n == 0) return 0;
        int m = a[0].length;
        int total = m * n;
        int b[] = new int[total];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                b[i * m + j] = a[i][j];
            }
        }

        Arrays.sort(b);

        /*for (int i = 0; i < total; i++) {
            System.out.println(i + " " + b[i] + " " + makeMatrixEqualHelper(b, b[i], k));
        }*/
        int median = b[total / 2];
        return makeMatrixEqualHelper(b, median, k);
    }

    private static int makeMatrixEqualHelper(int[] b, int m, int k) {
        int count = 0;
        for (int i = 0; i < b.length; i++) {
            count += Math.abs(b[i] - m) / k;
        }
        return count;
    }
}
