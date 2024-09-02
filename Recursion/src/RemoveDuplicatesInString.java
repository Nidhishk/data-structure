/**
 * Remove duplicates from a String
 */
public class RemoveDuplicatesInString {
    public static void main(String[] args) {
        String str = "abbccda";
        removeDuplicates(str, 0, "");
    }

    public static void removeDuplicates(String str, int idx, String newString) {
        if (idx == str.length()) {
            System.out.println(newString);
            return;
        }

        char currChar = str.charAt(idx);
        if (newString.indexOf(String.valueOf(currChar)) == -1) {
            // Not find duplicate character
            newString += currChar;
        }
        removeDuplicates(str, idx + 1, newString);
    }
}
