import java.util.ArrayList;
import java.util.Arrays;

public class PalindromicPartitioning {
    public static void main(String[] args) {
        String s = "abbaca";
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        palindromicHelper(s, 0, ans, new ArrayList<String>());
        for(ArrayList<String> list : ans) {
            System.out.println(list);
        }
    }

    private static void palindromicHelper(String s, int index, ArrayList<ArrayList<String>> ans, ArrayList<String> curr) {
        if (index == s.length()) {
            ArrayList<String> currCopy = new ArrayList<>(curr);
            ans.add(currCopy);
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                curr.add(s.substring(index, i + 1));       // as last index is excluded
                palindromicHelper(s, i + 1, ans, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int l, int r) {
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
