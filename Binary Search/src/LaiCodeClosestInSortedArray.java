//Time: O(log n)
//Space: O(1)
public class LaiCodeClosestInSortedArray {
    public class Solution {
        public int closest(int[] array, int target) {
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
                } else if (array[mid] > target) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
            if (Math.abs(array[left] - target) < Math.abs(array[right] - target)) {
                return left;
            } else {
                return right;
            }
        }
    }

}
