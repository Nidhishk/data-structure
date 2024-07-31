import java.util.Scanner;

// O(n) Time Complexity
public class Power {
    public static void main(String[] args) {
        System.out.print("x: ");
        Scanner sc = new Scanner(System.in);
        int x = Integer.parseInt(sc.next());

        System.out.print("n: ");
        Scanner sc1 = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        System.out.println("Value: " + calcPower(x,n));
    }

    public static int calcPower(int x, int n) {
        if(x == 0) {
            return 0;
        }

        if(n==0) {
            return 1;
        }

        return x * calcPower(x,n-1);
    }
}
