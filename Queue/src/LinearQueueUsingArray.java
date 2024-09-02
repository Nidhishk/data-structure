public class LinearQueueUsingArray {
    public static class Queue {
        static int size;
        static int arr[];
        static int rear = -1;

        Queue(int n) {
            arr = new int[n];
            this.size = n;
        }

        public boolean isEmpty() {
            return rear == -1;
        }

        public void add(int data) {
            // Check is Array is full or not
            if (rear == size - 1) {
                System.out.println("Queue is Full");
                return;
            }
            rear++;
            arr[rear] = data;
        }

        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }

            int front = arr[0];
            for (int i = 0; i <= rear; i++) {
                arr[i] = arr[i+1];
            }
            rear--;
            return front;
        }

        public int peek() {
            if(isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }
            return arr[0];
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue(6);
        queue.add(7);
        queue.add(3);
        queue.add(5);
        queue.remove();

        while(!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }
}