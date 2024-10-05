package advanced;

/**
 * Print all permutations of a string
 * Time Complexity :: O(n!)
 */
public class PrintStringPermutations {
    public static void main(String[] args) {
        printPermutations("abc", "");
    }

    public static void printPermutations(String str, String permutation) {
        if (str.length() == 0) {
            System.out.println(permutation);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);

            String newString = str.substring(0, i) + str.substring(i + 1);
            printPermutations(newString, permutation + currChar);
        }

    }
}
