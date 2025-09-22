package Revision;

import java.util.Scanner;

public class CountSubstringOccurance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Insert String: ");
        String s = sc.next();
        System.out.print("Insert Substring: ");
        String t = sc.next();

        System.out.println(countAllSubstrings(s, t, 0));
    }

    private static int countAllSubstrings(String s, String t, int idx) {
        if (idx >= s.length() - t.length()) {
            return 0;
        }

        int occurances = countAllSubstrings(s, t, idx + 1);
        if ((s.substring(idx, idx + t.length())).equals(t)) {
            return occurances + 1;
        } else {
            return occurances;
        }
    }
}
