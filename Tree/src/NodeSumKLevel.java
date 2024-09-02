import java.util.LinkedList;
import java.util.Queue;

public class NodeSumKLevel {
    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        int k = 2;
        System.out.println("Sum of nodes at level " + k + ": " + tree.sumAtKthLevel(root, k));
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

        // Function to find the sum of nodes at Kth level
        // Time Complexity:: O(n)
        public static int sumAtKthLevel(Node root, int k) {
            if (root == null) {
                return 0;
            }

            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            int level = 0;
            int sum = 0;

            while (!queue.isEmpty()) {
                int size = queue.size();
                sum = 0;    // Reset sum at the start of each level

                for (int i = 0; i < size; i++) {
                    Node node = queue.poll();

                    // If we are at the Kth level, add the node's value to the sum
                    if (level == k) {
                        sum += node.data;
                    }

                    // Add the node's children to the queue for the next level
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }

                // Increment the level counter
                if (level == k) {
                    break;
                }
                level++;
            }
            return sum;
        }
    }
}
