/**
 * Time Complexity :: O(Length of String) = O(n)
 */
public class PrintStringReverse {

    public static void main(String[] args) {
        String s = "abcd";
        printReverse(s, s.length() - 1);
    }

    private static void printReverse(String s, int idx) {
        if (idx == 0) {
            System.out.print(s.charAt(idx));
            return;
        }

        System.out.print(s.charAt(idx));
        printReverse(s, idx - 1);
    }
}
