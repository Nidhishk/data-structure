/**
 * Print keypad Combinations
 * Time Complexity :: O((Number of Choices)^n)
 */
public class KeypadCombinations {
    public static String[] keypad = {".", "abc", "def", "gh", "jkl", "mno", "pars", "tu", "vwx", "yz"};

    public static void main(String[] args) {
        String str = "23"; // Choices
        printCombinations(str, 0, "");
    }

    private static void printCombinations(String str, int idx, String combinations) {
        if (idx == str.length()) {
            System.out.println(combinations);
            return;
        }

        char currChar = str.charAt(idx);
        String mapping = keypad[currChar - '0'];

        for (int i = 0; i < mapping.length(); i++) {
            printCombinations(str, idx + 1, combinations + mapping.charAt(i));
        }
    }
}
