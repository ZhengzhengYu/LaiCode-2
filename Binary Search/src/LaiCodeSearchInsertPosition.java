public class LaiCodeSearchInsertPosition {
    //Time: O(log n)
    //Space: O(1)
    //找到小于target的第一个数，返回index + 1
    public class Solution {
        public int searchInsert(int[] input, int target) {
            // Write your solution here
            if (input == null || input.length == 0) {
                return 0;
            }
            int left = 0;
            int right = input.length - 1;
            while (left + 1 < right) {
                int mid = left + (right - left) / 2;
                if (input[mid] == target) {
                    right = mid;
                } else if (input[mid] > target) {
                    right = mid;
                } else {
                    left = mid;
                }
            }

            if (input[right] < target) {
                return right + 1;
            }
            if (input[left] < target) {
                return left + 1;
            }
            return 0;
        }
    }

}
