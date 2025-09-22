package Revision;

import java.util.Scanner;

public class PrintAllSubstrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Insert Valid String: ");
        String s = sc.next();
        allSubstrings(s);
    }

    private static void allSubstrings(String s) {
        allSubstringsHelper(s, 0, "");
    }

    private static void allSubstringsHelper(String s, int i, String curr) {
        if (i == s.length()) {
            System.out.println(curr);
            return;
        }

        allSubstringsHelper(s, i + 1, curr + s.charAt(i));
        allSubstringsHelper(s, i + 1, curr);
    }
}
