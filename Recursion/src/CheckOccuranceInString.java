import java.util.Scanner;

/*
Find the 1st & last occurance of an element in string
 */
// Time Complexity :: O(Length of String) = O(n)
public class CheckOccuranceInString {
    public static int first = -1;
    public static int last = -1;

    public static void main(String[] args) {
        System.out.print("Enter String: ");
        Scanner sc1 = new Scanner(System.in);
        String str = sc1.next();

        System.out.println();
        System.out.print("Enter only one character to be search in string: ");
        Scanner sc2 = new Scanner(System.in);
        char element = sc2.next().charAt(0);

        findOccurance(str, 0, element);
    }

    public static void findOccurance(String str, int idx, char element) {
        if (idx == str.length()) {
            System.out.println("First index of a character '" + element + "' in '" + str + "' is: " + first);
            System.out.println("Last index of a character '" + element + "' in '" + str + "' is: " + last);
            return;
        }

        char currChar = str.charAt(idx);
        if (currChar == element) {
            if (first == -1) {
                first = idx;
            } else {
                last = idx;
            }
        }
        findOccurance(str, idx + 1, element);
    }
}
