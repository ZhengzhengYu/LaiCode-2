import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LaiCodeMergeSort {
    //Time: O(nlog n)
    //Space: O(n)
    public class Solution {
        public int[] mergeSort(int[] array) {
            // Write your solution here
            if (array == null || array.length < 2) {
                return array;
            }
            List<Integer> result = helper(array, 0, array.length - 1);
            for (int i = 0; i < result.size(); i++) {
                array[i] = result.get(i);
            }
            return array;
        }

        private List<Integer> helper(int[] array, int left, int right) {
            //base case
            if (left == right) {
                return Arrays.asList(array[left]);
            }
            int mid = left + (right - left) / 2;
            List<Integer> leftSort = helper(array, left, mid);
            List<Integer> rightSort = helper(array, mid + 1, right);
            return combine(leftSort, rightSort);
        }

        private List<Integer> combine(List<Integer> left, List<Integer> right) {
            List<Integer> res = new ArrayList<>();
            int i = 0;
            int j = 0;
            while (i < left.size() && j < right.size()) {
                if (left.get(i) < right.get(j)) {
                    res.add(left.get(i));
                    i++;
                } else {
                    res.add(right.get(j));
                    j++;
                }
            }
            while (i < left.size()) {
                res.add(left.get(i));
                i++;
            }
            while (j < right.size()) {
                res.add(right.get(j));
                j++;
            }
            return res;
        }

    }

}
