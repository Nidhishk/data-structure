/**
 * Print all the subsequences of a string
 *
 * Total Number of Subsequences :: 2^n
 * Time Complexity :: ~O(2^n)
 */
public class SubsequenceOfString {
    public static void main(String[] args) {
        String str = "abc";
        subsequences(str, 0, "");
    }

    private static void subsequences(String str, int idx, String newString) {
        if (idx == str.length()) {
            System.out.println(newString);
            return;
        }

        char currChar = str.charAt(idx);

        // to be
        subsequences(str, idx + 1, newString + String.valueOf(currChar));

        // not to be
        subsequences(str, idx + 1, newString);
    }
}
