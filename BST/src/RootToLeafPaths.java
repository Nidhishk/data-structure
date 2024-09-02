import java.util.ArrayList;

public class RootToLeafPaths {
    public static void main(String[] args) {
        int values[] = {8, 5, 3, 6, 10, 11, 14};
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        inorderTraversal(root);
        System.out.println();

        rootToLeafPaths(root, new ArrayList<Integer>());
    }

    private static void rootToLeafPaths(Node root, ArrayList<Integer> paths) {
        if (root == null) {
            return;
        }

        paths.add(root.data);

        //Leaf
        if (root.left == null && root.right == null) {
            printPaths(paths);
        } else {
            rootToLeafPaths(root.left, paths);
            rootToLeafPaths(root.right, paths);
        }
        paths.remove(paths.size() - 1);
    }

    private static void printPaths(ArrayList<Integer> paths) {
        for (int i : paths) {
            System.out.print(i + " -> ");
        }
        System.out.println();
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }

        if (root.data > val) {
            // Left Subtree
            root.left = insert(root.left, val);
        } else {
            // Right Subtree
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void inorderTraversal(Node root) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }
}
