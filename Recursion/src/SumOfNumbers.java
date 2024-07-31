import java.util.Scanner;

public class SumOfNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        sumOfNum(1, n, 0);
    }

    public static void sumOfNum(int i, int n, int sum) {
        if (i == n) {
            System.out.println(sum);
            return;
        }
        sum += i;
        sumOfNum(i+1, n, sum);
    }
}
