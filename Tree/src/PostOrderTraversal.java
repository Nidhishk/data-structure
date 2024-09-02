public class PostOrderTraversal {
    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildBinaryTree(nodes);
        tree.postOrderTraversal(root);
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

        public static Node buildBinaryTree(int[] nodes) {
            idx++;

            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildBinaryTree(nodes);
            newNode.right = buildBinaryTree(nodes);
            return newNode;
        }

        public static void postOrderTraversal(Node root) {
            if (root == null) {
                return;
            }

            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.data + " ");
        }
    }
}
