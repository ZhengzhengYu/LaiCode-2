import java.util.LinkedList;

public class LaiCodeSortWith3Stacks {
    //Time: O(n^2)
    //Space: O(n) two stacks
    public class Solution {
        public void sort(LinkedList<Integer> s1) {
            LinkedList<Integer> s2 = new LinkedList<Integer>();
            LinkedList<Integer> s3 = new LinkedList<Integer>();
            // Write your solution here.
            while (!s1.isEmpty()) {
                int size = s1.size();
                //find global min in stack1
                int min = s1.peek();
                for (int i = 0 ; i < size; i++) {
                    int temp = s1.pop();
                    if (temp < min) {
                        min = temp;
                    }
                    s2.push(temp);
                }
                //count the number of min
                int num = 0;
                for (int i = 0; i < size; i++) {
                    int temp = s2.pop();
                    if (temp == min) {
                        num++;
                    } else {
                        s1.push(temp);
                    }
                }
                //push min into s3
                for (int i = 0; i < num; i++) {
                    s3.push(min);
                }
            }
            //result store from s3 into s1
            while (!s3.isEmpty()) {
                int temp = s3.pop();
                s1.push(temp);
            }
        }
    }

}
