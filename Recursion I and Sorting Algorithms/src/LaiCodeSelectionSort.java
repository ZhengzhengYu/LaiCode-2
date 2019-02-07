public class LaiCodeSelectionSort {
    //Time: O(n^2)
    //Space: O(1)
    public class Solution {
        public int[] solve(int[] array) {
            // Write your solution here
            if (array == null || array.length < 2) {
                return array;
            }
            for (int i = 0; i < array.length - 1; i++) {
                int min = i;
                //find the min in the subarray of (i + 1, array.length - 1)
                for (int j = i + 1; j < array.length; j++) {
                    if (array[j] < array[min]) {
                        min = j;
                    }
                }
                //swap
                int temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
            return array;
        }
    }
}
