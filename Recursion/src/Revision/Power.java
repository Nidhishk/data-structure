package Revision;

import java.util.Scanner;

public class Power {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Insert Valid Number: ");
        double a = sc.nextDouble();
        System.out.print("Insert Power: ");
        double b = sc.nextDouble();
        System.out.println("Output: " + power(a, b));
    }

    private static double power(double a, double b) {
        if (b == 0)
            return 1;

        return a * power(a, b - 1);
    }
}
