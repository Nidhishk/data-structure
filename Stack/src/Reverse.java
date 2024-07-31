import java.util.Stack;

public class Reverse {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(7);
        stack.push(3);
        stack.push(5);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    private static void reveseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int top = stack.pop();
        reveseStack(stack);
        pushElementAtBottom(top, stack);
    }

    private static void pushElementAtBottom(int data, Stack<Integer> s) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }

        int top = s.pop();
        pushElementAtBottom(data, s);
        s.push(top);
    }
}
