package advanced;

import java.util.ArrayList;

/**
 * Print all the subsets of a set of first n natural numbers
 * <p>
 * Time Complexity :: O(2^n)
 */
public class PrintSubsetsOfSets {
    public static void main(String[] args) {
        int n = 3;
        ArrayList<Integer> subset = new ArrayList<>();
        findSubsets(n, subset);
    }

    private static void findSubsets(int n, ArrayList<Integer> subset) {
        if (n == 0) {
            printSubsets(subset);
            return;
        }

        // Add hoga
        subset.add(n);
        findSubsets(n - 1, subset);

        // Add nhi hoga
        subset.remove(subset.size() - 1);
        findSubsets(n - 1, subset);
    }

    private static void printSubsets(ArrayList<Integer> subset) {
        for (int i = 0; i < subset.size(); i++) {
            System.out.print(subset.get(i) + " ");
        }
        System.out.println();
    }
}
