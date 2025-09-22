import java.util.ArrayList;

public class ArraySubsequence {
    public static void main(String[] args) {
        int arr[] = {3, 4, 5};
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        subsequenceHelper(arr, 0, ans, new ArrayList<Integer>());

        for (ArrayList<Integer> list : ans) {
            System.out.println(list);
        }
    }

    private static void subsequenceHelper(int[] arr, int index, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> curr) {
        ArrayList<Integer> currCopy = new ArrayList<>(curr);
        ans.add(currCopy);

        for (int i = index; i < arr.length; i++) {
            curr.add(arr[i]);
            subsequenceHelper(arr, i + 1, ans, curr);
            curr.remove(curr.size() - 1);   // Backtracking
        }
    }
}
