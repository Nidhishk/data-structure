import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        factorialNum(n);
    }

    public static int factorialNum(int n) {
        if (n == 0 && n == 1) {
            return 1;
        }

        int fact = factorialNum(n - 1);
        fact = fact * n;
        return fact;
    }
}
