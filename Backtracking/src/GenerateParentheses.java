import java.util.Scanner;

public class GenerateParentheses {
    public static void main(String[] args) {
        System.out.print("Enter n: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Output: ");
        generateParentheses(n, "", 0, 0);
    }

    private static void generateParentheses(int n, String curr, int open, int close) {
        if (open == n && close == n) {
            System.out.println(curr);
            return;
        }

        if (open < n) {
            curr = curr + "(";
            generateParentheses(n, curr, open + 1, close);
            curr = curr.substring(0, curr.length() - 1);
        }

        if (close < open) {
            curr = curr + ")";
            generateParentheses(n, curr, open, close + 1);
        }
    }
}
