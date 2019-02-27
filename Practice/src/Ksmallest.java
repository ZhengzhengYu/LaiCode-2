import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

//Time: O(n log k)
//Space: O(k)
public class Ksmallest {
    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 3, 4, 5, 6};
        System.out.println(Ksmallest(array, 7));
    }
    public static List<Integer> Ksmallest(int[] array, int k) {
        List<Integer> result = new ArrayList<>();
        if (array == null || array.length == 0 || k <= 0) {
            return result;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < array.length; i++) {
            if (i < k) {
                maxHeap.offer(array[i]);
            } else {
                if (maxHeap.peek() > array[i]) {
                    maxHeap.poll();
                    maxHeap.offer(array[i]);
                }
            }
        }
        //from guoguo 优化
//        for (int num : array) {
//            maxHeap.offer(num);
//            if (maxHeap.size() > k) {
//                maxHeap.poll();
//            }
//        }
        for (int i = maxHeap.size(); i > 0; i--) {
            result.add(maxHeap.poll());
        }
        return result;
    }
}
