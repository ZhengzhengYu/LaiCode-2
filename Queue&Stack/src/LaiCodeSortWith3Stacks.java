import java.util.LinkedList;

public class LaiCodeSortWith3Stacks {
    //Time: O(n^2)
    //Space: O(n)
    public class Solution {
        public void sort(LinkedList<Integer> s1) {
            LinkedList<Integer> s2 = new LinkedList<Integer>();
            LinkedList<Integer> s3 = new LinkedList<Integer>();
            // Write your solution here.
            while (!s1.isEmpty()) {
                int size = s1.size();
                //move elements from s1 to s2 to find the global min in s1
                int min = s1.peek();
                for (int i = 0; i < size; i++) {
                    int temp = s1.pop();
                    if (temp < min) {
                        min = temp;
                    }
                    s2.push(temp);
                }
                //move elements back from s2 to s1 except min and count the number of min
                int count = 0;
                for (int i = 0; i < size; i++) {
                    int temp = s2.pop();
                    if (temp == min) {
                        count++;
                    } else {
                        s1.push(temp);
                    }
                }
                //put min into s3
                for (int i = 0; i < count; i++) {
                    s3.push(min);
                }
            }
            //move elements from s3 to s1
            while (!s3.isEmpty()) {
                s1.push(s3.pop());
            }
        }
    }

}
