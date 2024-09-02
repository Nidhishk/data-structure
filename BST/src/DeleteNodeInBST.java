public class DeleteNodeInBST {
    public static void main(String[] args) {
        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        inorderTraversal(root);
        System.out.println();

        deleteNodeInTree(root, 10);
        inorderTraversal(root);
    }

    private static Node deleteNodeInTree(Node root, int keyToDelete) {
        if (root == null) {
            return null;
        }

        if (root.data > keyToDelete) {
            root.left = deleteNodeInTree(root.left, keyToDelete);
        } else if (root.data < keyToDelete) {
            root.right = deleteNodeInTree(root.right, keyToDelete);
        } else {    // root value is equal to key
            // Case 1
            // Left and right subtree is not present
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Case 3
            Node IS = inOrderSuccessor(root.right);
            root.data = IS.data;
            root.right = deleteNodeInTree(root.right, IS.data);
        }
        return root;
    }

    private static Node inOrderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
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
