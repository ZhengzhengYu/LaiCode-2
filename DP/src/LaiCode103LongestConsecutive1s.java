public class LaiCode103LongestConsecutive1s {
    //Solution: DP
    //maintains an array M[] and a global_max.
    //Base case:M[0] = array[0];
    //Induction rule:
    //M[i] represents the length of the longest subarray from index 0 to i-th element(included i).
    //M[i] = 0, iff input[i] = 0;
    //M[i] = M[i - 1] + 1, iff input[i] = 0;

    //Time: O(n)
    //Space: O(n)
    public int longest(int[] array) {
        // Write your solution here
        if (array.length == 0) {
            return 0;
        }

        int[] M = new int[array.length];
        M[0] = array[0];
        int global_max = M[0];
        for (int i = 1; i < array.length; i++) {
            M[i] = array[i] == 0 ? 0 : M[i - 1] + 1;
            if (M[i] > global_max) {
                global_max = M[i];
            }
        }

        return global_max;
    }
}
