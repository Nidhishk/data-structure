public class FindSubtree {
    public static void main(String[] args) {
        int[] nodes1 = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        BinaryTree.idx = -1;  // Reset the static index before building the tree
        Node root1 = tree.buildTree(nodes1);

        int[] nodes2 = {2, 4, -1, -1, 5, -1, -1};
        BinaryTree.idx = -1;  // Reset the static index before building the tree
        Node root2 = tree.buildTree(nodes2);

        // Checking if tree2 is a subtree of tree1
        if (tree.isSubTree(root1, root2)) {
            System.out.println("Tree2 is a subtree of Tree1");
        } else {
            System.out.println("Tree2 is not a subtree of Tree1");
        }
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int[] nodes) {
            idx++;

            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

        // Function to check if two trees are identical
        // Time Complexity:: O(n)
        public static boolean areIdentical(Node root1, Node root2) {
            // If Both trees are empty
            if (root1 == null && root2 == null) {
                return true;
            }

            // Both trees are non-empty, compare them
            if (root1 != null && root2 != null) {
                return (root1.data == root2.data) && areIdentical(root1.left, root2.left) && areIdentical(root1.right, root2.right);
            }

            // One tree is empty, and one is non-empty
            return false;
        }

        // Function to check if tree2 is a subtree of tree1
        // Time Complexity:: O(m*n)
        public static boolean isSubTree(Node root1, Node root2) {
            // An empty tree is always a subtree
            if (root1 == null) {
                return true;
            }

            // If tree1 is empty but tree2 is not, then tree2 cannot be a subtree
            if (root2 == null) {
                return true;
            }

            // Check if tree2 is identical to tree1
            if (areIdentical(root1, root2)) {
                return true;
            }

            // Otherwise, check if tree2 is a subtree of either subtree of tree1
            return isSubTree(root1.left, root2) || isSubTree(root1.right, root2);
        }
    }
}
