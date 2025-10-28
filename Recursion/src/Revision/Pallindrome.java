package Revision;

import java.util.Scanner;

public class Pallindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Insert Valid String: ");
        String s = sc.next();
        System.out.println("Is Pallindrome: " + pallindrome(s));
    }

    private static boolean pallindrome(String s) {
        return isPallindromeHelper(0, s.length() - 1, s);
    }

    private static boolean isPallindromeHelper(int l, int r, String s) {
        if (l >= r)
            return true;

        if (s.charAt(l) == s.charAt(r)) {
            return isPallindromeHelper(l + 1, r - 1, s);
        } else {
            return false;
        }
    }
}
