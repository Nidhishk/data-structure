import java.util.*;

public class QueueUsingStack {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.add(7);
        queue.add(3);
        queue.add(5);
        queue.remove();

        while (!queue.isEmpty()) {
            System.out.println(queue.peek());
            queue.remove();
        }
    }

    static class Queue {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        public boolean isEmpty() {
            return s1.isEmpty();
        }

        public void add(int data) {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            s1.push(data);

            while(!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        public int remove() {
            if(s1.isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }

            return s1.pop();
        }

        public int peek() {
            if(s1.isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }

            return s1.peek();
        }
    }
}
