public class LaiCodeMove0sToTheEndI {
    //Time: O(n)
    //Space: O(1)
    public class Solution {
        public int[] moveZero(int[] array) {
            // Write your solution here
            if (array == null || array.length < 2) {
                return array;
            }
            int i = 0;
            int j = array.length - 1;
            while (i <= j) {
                if (array[i] != 0) {
                    i++;
                } else {
                    swap(array, i, j);
                    j--;
                }
            }
            return array;
        }

        private void swap(int[] array, int i, int j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

    }

}
