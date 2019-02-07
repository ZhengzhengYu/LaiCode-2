public class LaiCodeRainbowSort {
    //Time: O(n)
    //Space: O(1)
    //三个挡板，四个区域: [0,i) => -1
    //                 [i,j) => 0
    //                 [j,k] => ?
    //                 (k,end] => 1
    public class Solution {
        public int[] rainbowSort(int[] array) {
            // Write your solution here
            if (array == null || array.length < 2) {
                return array;
            }
            int i = 0;
            int j = 0;
            int k = array.length - 1;
            while (j <= k) {
                if (array[j] == -1) {
                    swap(array, i, j);
                    i++;
                    j++;
                } else if (array[j] == 0) {
                    j++;
                } else if (array[j] == 1) {
                    swap(array, j, k);
                    k--;
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
