import java.util.Stack;

public class onestack2 {

    public static void main (String[] args) {
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(0);
        stack1.push(1);
        stack1.push(9);
        stack1.push(1);
        stack1.push(-4);
        stack1.push(1);

        Stack<Integer> temp = helper(stack1);
        while (!temp.isEmpty()) {
            System.out.println(temp.pop());
        }
    }

    //Time: O(n^2)
    //Space: O(n)
    public static Stack<Integer> helper(Stack<Integer> stack) {
        Stack<Integer> stack1 = new Stack<>();
        if (stack.isEmpty()) {
            return stack1;
        }
        while (!stack.isEmpty()) {
            int temp = stack.pop();
            if (stack1.isEmpty()) {
                stack1.push(temp);
            } else {
                while (!stack1.isEmpty() && temp > stack1.peek()) {
                    int num = stack1.pop();
                    stack.push(num);
                }
                stack1.push(temp);
            }
        }
        return stack1;
    }
}
