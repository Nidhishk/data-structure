import java.util.ArrayList;

public class StackWithAL {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(7);
        stack.push(5);
        stack.peek();
        stack.pop();
        System.out.println(stack.peek());
    }

    static class Stack {
        ArrayList<Integer> al = new ArrayList<>();

        public void isEmpty() {
            System.out.println("List is Empty");
        }

        public void push(int data) {
            al.add(data);
        }

        public int pop() {
            if (al.isEmpty()) {
                return -1;
            }

            int index = al.size() - 1;
            int top = al.get(index);
            al.remove(index);
            return top;
        }

        public int peek() {
            if (al.isEmpty()) {
                return -1;
            }
            return al.get(al.size() - 1);
        }
    }
}