public class CircularQueueUsingLinkedList {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.add(7);
        queue.add(3);
        queue.add(5);
        queue.add(9);
        queue.remove();

        while (!queue.isEmpty()) {
            System.out.println(queue.peek());
            queue.remove();
        }
    }

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Queue {
        Node front = null;
        Node rear = null;

        public boolean isEmpty() {
            return front == null && rear == null;
        }

        public void add(int data) {
            Node newNode = new Node(data);
            if (isEmpty()) {
                front = rear = newNode;
            } else {
                rear.next = newNode;
                rear = newNode;
            }
        }

        public int remove() {
            if (isEmpty()) {
                return -1;
            }

            int result = front.data;
            front = front.next;
            if (front == null) {
                rear = null;
            }
            return result;
        }

        public int peek() {
            if (isEmpty()) {
                return -1;
            }
            return front.data;
        }
    }
}
