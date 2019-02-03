public class LaiCodeKClosestInSortedArray {
    //Time: O((log n) + k)
    //Space: O(k)
    public class Solution {
        public int[] kClosest(int[] array, int target, int k) {
            // Write your solution here
            if (array == null || array.length == 0 || k == 0) {
                return new int[0];
            }
            int mid = findClosest(array, 0, array.length - 1, target);
            int left = mid - 1;
            int right = mid + 1;
            int[] result = new int[k];
            result[0] = array[mid];
            for (int i = 1; i < k; i++) {
                if (left >= 0 && right < array.length) {
                    if (Math.abs(array[left] - target) < Math.abs(array[right] - target)) {
                        result[i] = array[left--];
                    } else {
                        result[i] = array[right++];
                    }
                } else if (left >= 0) {
                    result[i] = array[left--];
                } else if (right < array.length) {
                    result[i] = array[right++];
                }
            }
            return result;
        }

        private int findClosest(int[] array, int left, int right, int target) {
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
            if (array[left] == target) {
                return left;
            }
            if (array[right] == target) {
                return right;
            }
            if (Math.abs(array[left] - target) < Math.abs(array[right] - target)) {
                return left;
            } else {
                return right;
            }
        }

    }

}
