// Time Complexity :: O(H)
public class SearchBST {
    public static void main(String[] args) {
        int values[] = {5, 1, 3, 4, 2, 7};
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        int keyToSearch = 8;
        System.out.println(searchInTree(root, keyToSearch));
    }

    public static boolean searchInTree(Node root, int key) {
        if (root == null) {
            return false;
        }

        if (root.data > key) {
            return searchInTree(root.left, key);
        } else if (root.data == key) {
            return true;
        } else {
            return searchInTree(root.right, key);
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
}