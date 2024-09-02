import java.util.LinkedList;
import java.util.Queue;

public class QueueUsingCollection {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(7);
        queue.add(3);
        queue.add(5);
        queue.add(1);
        queue.remove();


        while (!queue.isEmpty()) {
            System.out.println(queue.peek());
            queue.remove();
        }

    }
}
