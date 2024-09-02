import java.util.HashSet;

/**
 * Print all the subsequences of a string
 *
 * Total Number of Subsequences :: 2^n
 * Time Complexity :: ~O(2^n)
 */
public class UniqueSubsequenceOfString {
    public static void main(String[] args) {
        String str = "aaa";
        HashSet<String> set = new HashSet<String>();
        subsequences(str, 0, "", set);
    }

    private static void subsequences(String str, int idx, String newString, HashSet<String> set) {
        if (idx == str.length()) {
            if(set.contains(newString)) {
                return;
            } else {
                System.out.println(newString);
                set.add(newString);
                return;
            }
        }

        char currChar = str.charAt(idx);

        // to be
        subsequences(str, idx + 1, newString + String.valueOf(currChar), set);

        // not to be
        subsequences(str, idx + 1, newString, set);
    }
}
