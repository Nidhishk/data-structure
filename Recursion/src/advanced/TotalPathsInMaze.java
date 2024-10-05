package advanced;

/**
 * Count total paths in a maze to move from (0,0) to (n,m)
 *
 * By the use of Backtracing (It can be also done by Dynamic Programming)
 */
public class TotalPathsInMaze {
    public static void main(String[] args) {
        int n = 3;
        int m = 3;

        System.out.println(countPaths(0, 0, n, m));
    }

    public static int countPaths(int i, int j, int n, int m) {
        if (i == n || j == m) {
            return 0;
        }

        if (i == n - 1 || j == m - 1) {
            return 1;
        }

        // Move downwards
        int downPaths = countPaths(i + 1, j, n, m);

        // Move Right
        int rightPaths = countPaths(i, j + 1, n, m);

        return downPaths + rightPaths;
    }
}
