public class PrintInRange {
    public static void main(String[] args) {
        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        inorderTraversal(root);
        System.out.println();

        printInRange(root, 6, 10);
    }

    private static void printInRange(Node root, int X, int Y) {
        if (root == null) {
            return;
        }

        if (root.data >= X && root.data <= Y) {
            printInRange(root.left, X, Y);
            System.out.println(root.data + " ");
            printInRange(root.right, X, Y);
        } else if (root.data >= Y) {
            printInRange(root.left, X, Y);
        } else {
            printInRange(root.right, X, Y);
        }
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
