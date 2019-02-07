public class LaiCodeQuickSort {
    //Time: O(nlog n)
    //Space: o(log n)
    public class Solution {
        public int[] quickSort(int[] array) {
            // Write your solution here
            if (array == null || array.length < 2) {
                return array;
            }
            helper(array, 0, array.length - 1);
            return array;
        }

        //在array[left, right]区间排序
        private void helper(int[] array, int left, int right) {
            //base case
            if (left >= right) {
                return;
            }
            //recursion rule
            int pivotIndex = left + (int)Math.random() * (right - left + 1);
            int pivot = array[pivotIndex];
            swap(array, pivotIndex, right);
            int i = left;
            int j = right - 1;
            while (i <= j) {
                if (array[i] < pivot) {
                    i++;
                } else {
                    swap(array, i, j);
                    j--;
                }
            }
            swap(array, i, right);

            helper(array, left, i - 1);
            helper(array, i + 1, right);
        }

        private void swap(int[] array, int i, int j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

    }

}
