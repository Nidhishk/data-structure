package Revision;

import java.util.HashMap;
import java.util.Map;

public class LongestUniqueSubstring {

    /**
     * Returns the longest substring without repeating characters.
     */
    public static String longestUniqueSubstr(String s) {
        if (s == null || s.isEmpty()) return "";

        Map<Character, Integer> lastIndex = new HashMap<>(); // char -> last seen index
        int start = 0;      // window start index
        int bestLen = 0;    // best window length found
        int bestStart = 0;  // start index of best window

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If char was seen and is inside current window, move start right after its last index
            if (lastIndex.containsKey(c) && lastIndex.get(c) >= start) {
                start = lastIndex.get(c) + 1;
            }

            // Update last seen index for this char
            lastIndex.put(c, i);

            // Update best window if current is longer
            int currentLen = i - start + 1;
            if (currentLen > bestLen) {
                bestLen = currentLen;
                bestStart = start;
            }
        }

        return s.substring(bestStart, bestStart + bestLen);
    }

    public static void main(String[] args) {
        String input = "abcabcbb";
        String result = longestUniqueSubstr(input);
        System.out.println("Input: " + input);
        System.out.println("Longest substring without repeating characters: " + result);
        // Expected output: "abc"
    }
}
