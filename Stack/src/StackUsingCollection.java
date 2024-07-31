import java.util.*;

public class StackUsingCollection {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(8);
        stack.push(5);
        stack.push(6);
        stack.pop();
        System.out.println(stack);
    }
}
