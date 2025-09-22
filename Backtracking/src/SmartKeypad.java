import java.util.Scanner;

public class SmartKeypad {
    public static void main(String[] args) {
        String map[] = {
                "", "",
                "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        System.out.print("Insert Number from Keypad: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println("Output: ");
        smartKeypadHelper(input, map, "", 0);
    }

    private static void smartKeypadHelper(String input, String map[], String curr, int index) {
        if (index == input.length()) {
            System.out.println(curr);
            return;
        }

        // To fetch its particular index
        int keypadNumber = input.charAt(index) - '0';
        String keypadString = map[keypadNumber];

        /*for (int i = 0; i < keypadString.length(); i++) {
            smartKeypadHelper(input, map, curr + keypadString.charAt(i), index + 1);
        }*/

        // For Backtracking
        for (int i = 0; i < keypadString.length(); i++) {
            curr = curr + keypadString.charAt(i);
            smartKeypadHelper(input, map, curr, index + 1);
            curr = curr.substring(0, curr.length() - 1);
        }
    }
}
