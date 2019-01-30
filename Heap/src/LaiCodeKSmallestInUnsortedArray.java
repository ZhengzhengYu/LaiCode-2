import java.util.*;

public class LaiCodeKSmallestInUnsortedArray {

    //Method 1
    //min heap
//    public class Solution {
//      public int[] kSmallest(int[] array, int k) {
//        int[] result = new int[k];
//        if (array == null || array.length == 0 || k == 0) {
//          return result;
//        }
//
//        List<Integer> list = new ArrayList<>();
//        for (int num : array) {
//          list.add(num);
//        }
//        Queue<Integer> pq = new PriorityQueue<>(list);
//        for (int i = 0; i < k; i++) {
//          result[i] = pq.poll();
//        }
//        return result;
//      }
//    }

    //Method 2
    //max heap
//    public class Solution {
//        public int[] kSmallest(int[] array, int k) {
//            int[] result = new int[k];
//            if (array == null || array.length == 0 || k == 0) {
//                return result;
//            }
//            Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
//            for (int i = 0; i < k; i++) {
//                pq.offer(array[i]);
//            }
//            for (int i = k; i < array.length; i++) {
//                if (array[i] <= pq.peek()) {
//                    pq.poll();
//                    pq.offer(array[i]);
//                }
//            }
//            for (int i = k; i > 0; i--) {
//                result[i - 1] = pq.poll();
//            }
//            return result;
//        }
//    }



    // Method 3
    //QuickSelect: QuickSort
    //选择一个index，通过QuickSort，左边的都比index小，右边的都比index大
    //Time Complexity: O(n) on average; O(n^2) worse case
    //Space Complexity: O(log n) on average; O(n) worse case
    public class Solution {
        public int[] kSmallest(int[] array, int k) {
            int[] result = new int[k];
            if (array == null || array.length == 0 || k == 0) {
                return result;
            }
            QuickSelect(array, k, 0, array.length - 1);
            for (int i = 0; i < k; i++) {
                result[i] = array[i];
            }
            Arrays.sort(result);
            return result;
        }

        private void QuickSelect(int[] array, int k, int left, int right) {
            if (left >= right) {
                return;
            }
            Random random = new Random();
            int pivotIndex = left + random.nextInt(right - left + 1);
            //put the pivotIndex at the right at first
            swap(array, pivotIndex, right);
            int l = left;
            int r = right - 1;
            while (l <= r) {
                if (array[l] < array[right]) {
                    l++;
                } else {
                    swap(array, l, r);
                    r--;
                }
            }
            //put int pivotIndex at the right place, left small than pivotIndex, right big than pivotIndex
            swap(array, l, right);
            if (k < l) {
                QuickSelect(array, k, left, l - 1);
            } else {
                QuickSelect(array, k, l + 1, right);
            }
        }

        private void swap(int[] array, int i, int j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

    }

}
