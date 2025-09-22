
public class EliminationGame {
    public static void main(String[] args) {
        System.out.println(lastRemaining(9));
    }

    private static int lastRemaining(int n) {
        int head = 1;            // First element
        int step = 1;            // Step size between elements
        int remaining = n;       // Elements remaining in current iteration
        boolean leftToRight = true;   // Direction of elimination

        while (remaining > 1) {
            // If eliminating from left OR remaining is odd and eliminating from right, head moves forward
            if (leftToRight || remaining % 2 == 1) {
                head += step;
            }
            remaining /= 2;
            step *= 2;
            leftToRight = !leftToRight;
        }

        return head;
    }
}
