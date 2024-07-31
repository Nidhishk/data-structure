import java.util.Stack;

public class PushElementBottom {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack();
        s.push(7);
        s.push(3);
        s.push(5);
        pushElementAtBottom(2, s);

        while(!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    private static void pushElementAtBottom(int data, Stack<Integer> s) {
        if(s.isEmpty()) {
            s.push(data);
            return;
        }

        int top = s.pop();
        pushElementAtBottom(data, s);
        s.push(top);
    }
}
