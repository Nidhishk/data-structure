import java.util.Arrays;

public class WaveArray {
    public static void main(String[] args) {
        int a[] = {4, 2, 9, 6, 3, 7, 5};
        Arrays.sort(a);
        waveArray(a);
        //waveArrayNotLexographic(a);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    private static void waveArray(int a[]) {
        int n = a.length;
        for (int i = 1; i < n; i += 2) {
            swap(a, i, i - 1);
        }
    }

    private static void waveArrayNotLexographic(int a[]) {
        int n = a.length;
        for (int i = 1; i < n; i += 2) {
            if (a[i] > a[i - 1]) {
                swap(a, i, i - 1);
            }
            if (i < n - 1 && a[i] > a[i + 1]) {
                swap(a, i, i + 1);
            }
        }
    }

    private static void swap(int[] a, int i, int i1) {
        int temp = a[i];
        a[i] = a[i - 1];
        a[i - 1] = temp;
    }
}
