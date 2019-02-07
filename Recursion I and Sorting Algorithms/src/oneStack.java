import java.util.Stack;

public class oneStack {
    public static void main (String[] args) {
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(0);
        stack1.push(1);
        stack1.push(9);
        stack1.push(1);
        stack1.push(-4);
        stack1.push(1);

        Stack<Integer> temp = selectSort(stack1);
        while (!temp.isEmpty()) {
            System.out.println(temp.pop());
        }
    }

    //Time: O(n^2)
    //Space: O(n)
    public static Stack<Integer> selectSort(Stack<Integer> S1) {
        Stack<Integer> S2 = new Stack<>();
        while (!S1.isEmpty()) {
            int size = S1.size();
            int min = S1.peek();
            //find the min and push the elements to the S2
            for (int i = 0; i < size; i++) {
                int temp = S1.pop();
                if (temp < min) {
                    min = temp;
                }
                S2.push(temp);
            }
            //the count of min
            int num = 0;
            for (int i = 0; i < size; i++) {
                int temp = S2.pop();
                if (temp == min) {
                    num++;
                } else {
                    S1.push(temp);
                }
            }
            //push min into S2 for num times
            for (int i = 0; i < num; i++) {
                S2.push(min);
            }
        }
        return S2;
    }
}
