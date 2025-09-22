package Revision;

import java.util.Scanner;

public class FastPower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Insert a: ");
        int a = sc.nextInt();
        System.out.print("Insert b: ");
        int b = sc.nextInt();
        System.out.println("Output: " + fastPower(a, b));
    }

    private static int fastPower(int a, int b) {
        if (b == 0)
            return 1;
        if (b < 0)
            return fastPower(1 / a, Math.abs(b));

        if (b % 2 == 0) {
            // Even
            return fastPower(a * a, b / 2);
        } else {
            // Odd
            return a * fastPower(a, b - 1);
        }
    }
}
