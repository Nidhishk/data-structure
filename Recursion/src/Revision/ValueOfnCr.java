package Revision;

import java.util.Scanner;

public class ValueOfnCr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Insert n: ");
        int n = sc.nextInt();
        System.out.print("Insert r: ");
        int r = sc.nextInt();
        System.out.println("Output: " + nCr(n, r));
    }

    private static int nCr(int n, int r) {
        if (r == 0 || n == r || n == 1)
            return 1;

        return nCr(n - 1, r - 1) + nCr(n - 1, r);
    }
}
