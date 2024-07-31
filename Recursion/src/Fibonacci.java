import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        System.out.println(0);
        System.out.println(1);
        fibonacciOfNum(0, 1, n);
    }

    public static void fibonacciOfNum(int a, int b, int n) {
        if (n == 0) {
            return;
        }
        int c = a + b;
        System.out.println(c);
        fibonacciOfNum(b, c, n - 1);
    }
}
