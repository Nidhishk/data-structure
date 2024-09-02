public class PreOrderTraversal {

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.buildBinaryTree(nodes);
        binaryTree.preOrderBinaryTree(root);
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

        public static void preOrderBinaryTree(Node root) {
            if (root == null) {
                return;
            }

            System.out.print(root.data + " ");
            preOrderBinaryTree(root.left);
            preOrderBinaryTree(root.right);
        }

        public Node buildBinaryTree(int[] nodes) {
            idx++;

            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildBinaryTree(nodes);
            newNode.right = buildBinaryTree(nodes);
            return newNode;
        }
    }
}
