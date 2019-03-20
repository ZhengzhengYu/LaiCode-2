//Time: O(n)
//Space: O(n) -->optimized to O(1)
public class LaiCode97LargestSubArraySum {
    public int largestSum(int[] array) {
        // Write your solution here
        //M[i] represents from 0 index to i index (included i) the greatest sum
        int[] M = new int[array.length];
        //base case
        M[0] = array[0];
        int global_max = array[0];
        //induction rule
        for (int i = 1; i < array.length; i++) {
            M[i] = Math.max(array[i], array[i] + M[i - 1]);
            global_max = Math.max(global_max, M[i]);
        }
        return global_max;
    }
}
