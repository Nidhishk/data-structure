package Revision;

import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Insert m: ");
        int m = sc.nextInt();
        System.out.print("Insert n: ");
        int n = sc.nextInt();
        System.out.println("Output: " + matrix(m, n));
    }

    private static int matrix(int m, int n) {
        if (m == 0 || n == 0)
            return 0;

        if (m == 1 || n == 1)
            return 1;

        return matrix(m - 1, n) + matrix(m, n - 1);
    }
}
