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
    public class Solution {
        public int[] kSmallest(int[] array, int k) {
            int[] result = new int[k];
            if (array == null || array.length == 0 || k == 0) {
                return result;
            }
            Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            for (int i = 0; i < k; i++) {
                pq.offer(array[i]);
            }
            for (int i = k; i < array.length; i++) {
                if (array[i] <= pq.peek()) {
                    pq.poll();
                    pq.offer(array[i]);
                }
            }
            for (int i = k; i > 0; i--) {
                result[i - 1] = pq.poll();
            }
            return result;
        }
    }

}
