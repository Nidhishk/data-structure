/**
 * Print all possible combination of the String
 * <p>
 * Time Complexity :: O(n*n!) :: O(Steps * Answers)
 */
public class Backtracking {
    public static void main(String[] args) {
        String str = "ABC";
        printPermutations(str, "", 0);
    }

    public static void printPermutations(String str, String perm, int idx) {
        if (str.length() == 0) {
            System.out.println(perm);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            String newString = str.substring(0, i) + str.substring(i + 1);
            printPermutations(newString, perm + currChar, idx + 1);
        }
    }
}