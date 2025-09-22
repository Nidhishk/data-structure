package Revision;

import java.util.Scanner;

public class PowerWithModulo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Insert a: ");
        int a = sc.nextInt();
        System.out.print("Insert b: ");
        int b = sc.nextInt();
        System.out.print("Insert modulo m: ");
        int m = sc.nextInt();
        System.out.println("Output: " + fastPowerWithModulo(a, b, m));
    }

    private static int fastPowerWithModulo(int a, int b, int m) {
        if (b == 0)
            return 1;

        if (b < 0)
            return fastPowerWithModulo(1 / a, Math.abs(b), m);

        if (b % 2 == 0) {
            // Even
            return fastPowerWithModulo(a % m * a % m, b / 2, m);
        } else {
            // Odd
            return (a * fastPowerWithModulo(a % m, b - 1, m)) % m;
        }
    }
}
