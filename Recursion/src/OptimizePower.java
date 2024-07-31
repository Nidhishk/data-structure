import java.util.Scanner;

// O(logn) Time Complexity
public class OptimizePower {
    public static void main(String[] args) {
        System.out.print("x: ");
        Scanner sc = new Scanner(System.in);
        int x = Integer.parseInt(sc.next());

        System.out.print("n: ");
        Scanner sc1 = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        System.out.println("Value: " + calcPower(x, n));
    }

    public static int calcPower(int x, int n) {
        if (x == 0) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        // Even
        if (n % 2 == 0) {
            return calcPower(x, n / 2) * calcPower(x, n / 2);
        } else {
            return x * calcPower(x, n / 2) * calcPower(x, n / 2);
        }
    }
}
