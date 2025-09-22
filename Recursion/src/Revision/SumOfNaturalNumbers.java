package Revision;

import java.util.Scanner;

public class SumOfNaturalNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Insert Valid Integer: ");
        int n = sc.nextInt();
        System.out.println("Output: " + sumOfN(n));
    }

    private static int sumOfN(int n) {
        if(n == 0)
            return 0;

        return sumOfN(n-1) + n;
    }
}
