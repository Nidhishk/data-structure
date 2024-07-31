import java.util.Scanner;

public class PrintReverseNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        printNum(n);
    }

    public static void printNum(int n) {
        if (n == 0) {
            return;
        }

        System.out.print(n + " ");
        printNum(n - 1);
    }
}