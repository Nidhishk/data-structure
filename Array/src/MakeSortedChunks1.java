public class MakeSortedChunks1 {
    public static void main(String[] args) {
        int[] a = {3, 4, 5, 2, 0, 1, 6};
        System.out.println(maxChunksToSorted(a));
    }

    private static int maxChunksToSorted(int[] a) {
        int maxSoFar = a[0];
        int chunks = 0;

        for (int i = 0; i < a.length; i++) {
            if(a[i] > maxSoFar) {
                maxSoFar = a[i];
            }
            if(i == maxSoFar) {
                chunks++;
            }
        }
        return chunks;
    }
}
