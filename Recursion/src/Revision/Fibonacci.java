package Revision;

import java.util.Scanner;

// 1,1,2,3,5,8,13,21,......
public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Insert Valid Integer: ");
        int n = sc.nextInt();
        System.out.println("Output: " + fibonacci(n));
    }

    private static int fibonacci(int n) {
        if (n <= 1)
            return n;

        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
