public class LaiCodeSearchInShiftedSortedArrayI {
    //Time: O(log n)
    //Space: O(1)
    public class Solution {
        public int search(int[] array, int target) {
            // Write your solution here
            if (array == null || array.length == 0) {
                return -1;
            }
            int left = 0;
            int right = array.length - 1;
            while (left + 1 < right) {
                int mid = left + (right - left) / 2;
                if (array[mid] == target) {
                    return mid;
                }
                //left side
                if (array[left] < array[mid]) {
                    if (target >= array[left] && target <= array[mid]) {
                        right = mid;
                    } else {
                        left = mid;
                    }
                } else { // right side
                    if (target >= array[mid] && target <= array[right]) {
                        left = mid;
                    } else {
                        right = mid;
                    }
                }
            }
            if (array[left] == target) {
                return left;
            }
            if (array[right] == target) {
                return right;
            }
            return -1;
        }
    }

}
