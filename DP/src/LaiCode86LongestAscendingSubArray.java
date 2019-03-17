public class LaiCode86LongestAscendingSubArray {
    //Time: O(n)
    //Space: O(n)
    public int longest(int[] array) {
        // Write your solution here
        if (array.length == 0) {
            return 0;
        }
        //M[i] represents from 0th element to i-th element(included i-th element)
        //the max length of ascending array
        int[] M = new int[array.length];
        //base case
        M[0] = 1;
        int global_max = M[0];
        //induction rule
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                M[i] = M[i - 1] + 1;
            } else {
                M[i] = 1;
            }
            global_max = Math.max(global_max, M[i]);
        }
        return global_max;
    }
}
