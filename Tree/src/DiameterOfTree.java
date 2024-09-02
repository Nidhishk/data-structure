public class DiameterOfTree {
    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(tree.diameterOfTree(root));
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

        public static int height(Node root) {
            if (root == null) {
                return 0;
            }

            int heightOfLeftSubtree = height(root.left);
            int heightOfRightSubtree = height(root.right);
            return Math.max(heightOfLeftSubtree, heightOfRightSubtree) + 1;
        }

        // Time Complexity :: O(n^2)
        public static int diameterOfTree(Node root) {
            if (root == null) {
                return 0;
            }

            int dim1 = diameterOfTree(root.left);
            int dim2 = diameterOfTree(root.right);
            int dim3 = height(root.left) + height(root.right) + 1;
            return Math.max(dim3, Math.max(dim1, dim2));
        }
    }
}