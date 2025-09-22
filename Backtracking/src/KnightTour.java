import java.util.Scanner;

public class KnightTour {
    public static void main(String[] args) {
        System.out.print("Enter the size of chess board N*N: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] moveX = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] moveY = {1, 2, 2, 1, -1, -2, -2, -1};

        int arr[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = -1;
            }
        }
        arr[0][0] = 0; // Start from 0,0 with step 0

        knightTourHelper(n, arr, moveX, moveY, 1, 0, 0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean knightTourHelper(int n, int[][] arr, int[] moveX, int[] moveY, int step, int currX, int currY) {
        if (step == n * n)
            return true;

        for (int i = 0; i < 8; i++) {
            int nextX = currX + moveX[i];
            int nextY = currY + moveY[i];
            if (isValid(n, arr, nextX, nextY)) {
                arr[nextX][nextY] = step;
                boolean isTourCompletedByGoingThere = knightTourHelper(n, arr, moveX, moveY, step + 1, nextX, nextY);
                if (isTourCompletedByGoingThere) {
                    return true;
                } else {
                    arr[nextX][nextY] = -1; // Backtracking
                }
            }
        }
        return false;
    }

    private static boolean isValid(int n, int[][] arr, int nextX, int    nextY) {
        return nextX >= 0 && nextY >= 0 && nextX < n && nextY < n && arr[nextX][nextY] == -1;
    }
}
