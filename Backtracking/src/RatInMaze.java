public class RatInMaze {
    public static void main(String[] args) {
        int mat[][] = {
                {1, 1, 1, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {1, 1, 1, 1}
        };

        int m = mat.length; // rows
        int n = mat[0].length;  // columns
        boolean vis[][] = new boolean[m][n];
        vis[0][0] = true;   // Initial Condition

        ratInMaze(mat, vis, m, n, 0, 0, "");
    }

    private static boolean isValid(int mat[][], boolean vis[][], int m, int n, int i, int j) {
        if (i < m && j < n && i >= 0 && j >= 0 && mat[i][j] == 1 && !vis[i][j])
            return true;
        return false;
    }

    // D,L,R,U
    private static void ratInMaze(int mat[][], boolean vis[][], int m, int n, int i, int j, String path) {
        // Base Condition
        if (i == m - 1 && j == n - 1) {
            System.out.println(path);
            return;
        }

        if (isValid(mat, vis, m, n, i + 1, j)) {    // D
            vis[i + 1][j] = true;
            ratInMaze(mat, vis, m, n, i + 1, j, path + "D");
            vis[i + 1][j] = false;
        }

        if (isValid(mat, vis, m, n, i, j - 1)) {    // L
            vis[i][j - 1] = true;
            ratInMaze(mat, vis, m, n, i, j - 1, path + "L");
            vis[i][j - 1] = false;
        }

        if (isValid(mat, vis, m, n, i, j + 1)) {    // R
            vis[i][j + 1] = true;
            ratInMaze(mat, vis, m, n, i, j + 1, path + "R");
            vis[i][j + 1] = false;
        }

        if (isValid(mat, vis, m, n, i - 1, j)) {    // U
            vis[i - 1][j] = true;
            ratInMaze(mat, vis, m, n, i - 1, j, path + "U");
            vis[i - 1][j] = false;
        }
    }
}
