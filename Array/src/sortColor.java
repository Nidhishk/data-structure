public class sortColor {
    public static void main(String[] args) {
        int a[] = {2, 1, 2, 1, 0, 0, 1, 0, 2};
        sortArray(a);
        for (int e : a) {
            System.out.print(e + " ");
        }
    }

    private static void sortArray(int a[]) {
        int low = 0;
        int mid = 0;
        int high = a.length - 1;

        while (mid <= high) {
            if (a[mid] == 2) {
                a[mid] = a[high];
                a[high] = 2;
                high--;
            } else if (a[mid] == 1) {
                mid++;
            } else if (a[mid] == 0) {
                a[mid] = a[low];
                a[low] = 0;
                low++;
                mid++;
            }
        }
    }
}
