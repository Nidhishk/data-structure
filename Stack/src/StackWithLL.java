import java.util.LinkedList;

public class StackWithLL {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(7);
        stack.push(3);
        stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Stack {
        public static Node head = null;

        public void push(int data) {
            Node newNode = new Node(data);

            if (head == null) {
                head = newNode;
                return;
            }

            newNode.next = head;
            head = newNode;
        }

        public static boolean isEmpty() {
            return head == null;
        }

        public int pop() {
            if(isEmpty()) {
                return -1;
            }

            int popData = head.data;
            Node currNode = head.next;
            head = currNode;
            return popData;
        }
    }
}
