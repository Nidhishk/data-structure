public class InOrderTraversal {
    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.buildBinaryTree(nodes);
        binaryTree.inOrderTraversal(root);
    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class BinaryTree {
        public static int idx = -1;

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

        public static void inOrderTraversal(Node root) {
            if (root == null) {
                return;
            }

            inOrderTraversal(root.left);
            System.out.print(root.data + " ");
            inOrderTraversal(root.right);
        }
    }
}
