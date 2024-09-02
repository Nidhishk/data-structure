/**
 * Move all 'x' to the end of the string
 */
// Time Complexity :: O(n + count) == O(2n) == O(n)
public class MoveAllXAtEnd {
    public static void main(String[] args) {
        String str = "axbcxxd";
        moveAllX(str, 0, 0, "");
    }

    public static void moveAllX(String str, int idx, int count, String newString) {
        if (idx == str.length()) {
            for (int i = 0; i < count; i++) {
                newString += 'x';
            }
            System.out.println(newString);
            return;
        }

        char currChar = str.charAt(idx);
        if (currChar == 'x') {
            moveAllX(str, idx + 1, count + 1, newString);
        } else {
            newString += str.charAt(idx);
            moveAllX(str, idx + 1, count, newString);
        }
    }
}
