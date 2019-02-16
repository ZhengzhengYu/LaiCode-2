import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LaiCodeMergeSort {
    //Time: O(nlog n)
    //Space: O(n)
    //分析：函数中分配了很多临时变量
//    public class Solution {
//        public int[] mergeSort(int[] array) {
//            // Write your solution here
//            if (array == null || array.length < 2) {
//                return array;
//            }
//            List<Integer> result = helper(array, 0, array.length - 1);
//            for (int i = 0; i < result.size(); i++) {
//                array[i] = result.get(i);
//            }
//            return array;
//        }
//
//        private List<Integer> helper(int[] array, int left, int right) {
//            //base case
//            if (left == right) {
//                return Arrays.asList(array[left]);
//            }
//            int mid = left + (right - left) / 2;
//            List<Integer> leftSort = helper(array, left, mid);
//            List<Integer> rightSort = helper(array, mid + 1, right);
//            return combine(leftSort, rightSort);
//        }
//
//        private List<Integer> combine(List<Integer> left, List<Integer> right) {
//            List<Integer> res = new ArrayList<>();
//            int i = 0;
//            int j = 0;
//            while (i < left.size() && j < right.size()) {
//                if (left.get(i) < right.get(j)) {
//                    res.add(left.get(i));
//                    i++;
//                } else {
//                    res.add(right.get(j));
//                    j++;
//                }
//            }
//            while (i < left.size()) {
//                res.add(left.get(i));
//                i++;
//            }
//            while (j < right.size()) {
//                res.add(right.get(j));
//                j++;
//            }
//            return res;
//        }
//
//    }


    //Time: O(n log n)
    //Space: O(n)
    //using the same array(temp) to bound menmory consumption
    public class Solution {
        public int[] mergeSort(int[] array) {
            // Write your solution here
            if (array == null || array.length < 2) {
                return array;
            }
            //allocate temp array to help merge step, so that we guarantee no more than O(n) space is used.
            //the space complexity is O(n) in this case.
            int[] temp = new int[array.length];
            helper(array, temp, 0, array.length - 1);
            return array;
        }

        private void helper(int[] array, int[] temp, int left, int right) {
            //base case
            if (left >= right) {
                return;
            }
            //recursion rule
            int mid = left + (right - left) / 2;
            helper(array, temp, left, mid);
            helper(array, temp, mid + 1, right);
            merge(array, temp, left, mid, right);
        }

        private void merge(int[] array, int[] temp, int left, int mid, int right) {
            //copy the content to temp array, we will merge form temp array
            for (int i = left; i <= right; i++) {
                temp[i] = array[i];
            }
            int leftIndex = left;
            int rightIndex = mid + 1;
            while (leftIndex <= mid && rightIndex <= right) {
                if (temp[leftIndex] < temp[rightIndex]) {
                    array[left++] = temp[leftIndex++];
                } else {
                    array[left++] = temp[rightIndex++];
                }
            }
            //if we still have some elements at the left side, we need to copy them
            while (leftIndex <= mid) {
                array[left++] = temp[leftIndex++];
            }
            //if there are some elements at the right side, we do not need to copy them
            //because they are already in their position
        }

    }


}
