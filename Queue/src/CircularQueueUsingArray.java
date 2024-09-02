public class CircularQueueUsingArray {
    public static void main(String[] args) {
        Queue queue = new Queue(6);
        queue.add(7);
        queue.add(3);
        queue.add(5);
        queue.remove();

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }

    static class Queue {
        static int arr[];
        static int size;
        static int front = -1;
        static int rear = -1;

        Queue(int n) {
            arr = new int[n];
            size = n;
        }

        public boolean isEmpty() {
            return front == -1 && rear == -1;
        }

        public boolean isFull() {
            return (rear + 1) % size == front;
        }

        public void add(int data) {
            if (isFull()) {
                return;
            }

            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        public int remove() {
            if (isEmpty()) {
                return -1;
            }

            int result = arr[front];
            if (front == rear) {
                return front = rear = -1;
            } else {
                front = (front + 1) % size;
            }

            return result;
        }

        public int peek() {
            if(isEmpty()) {
                return -1;
            }
            return arr[front];
        }
    }
}
