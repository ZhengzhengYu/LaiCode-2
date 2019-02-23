import java.util.*;

public class LaiCodeKSmallestInUnsortedArray {
    //Method 1: MergeSort
    //Time: O(n log n)
    //Space: O(n)
    //public class Solution {
    //  public int[] kSmallest(int[] array, int k) {
    //    int[] result = new int[k];
    //    if (array.length == 0 || k == 0) {
    //      return result;
    //    }
    //    int[] helper = new int[array.length];
    //    mergeSort(array, 0, array.length - 1, helper);
    //    for (int i = 0; i < k; i++) {
    //      result[i] = array[i];
    //    }
    //    return result;
    //  }
    //
    //  private void mergeSort(int[] array, int left, int right, int[] helper) {
    //    //base case
    //    if (left >= right) {
    //      return;
    //    }
    //    int mid = left + (right - left) / 2;
    //    mergeSort(array, left, mid, helper);
    //    mergeSort(array, mid + 1, right, helper);
    //    merge(array, left, mid, right, helper);
    //  }
    //
    //  private void merge(int[] array, int left, int mid, int right, int[] helper) {
    //    for (int i = left; i <= right; i++) {
    //      helper[i] = array[i];
    //    }
    //    int leftIndex = left;
    //    int rightIndex = mid + 1;
    //    while (leftIndex <= mid && rightIndex <= right) {
    //      if (helper[leftIndex] < helper[rightIndex]) {
    //        array[left++] = helper[leftIndex++];
    //      } else {
    //        array[left++] = helper[rightIndex++];
    //      }
    //    }
    //    while (leftIndex <= mid) {
    //      array[left++] = helper[leftIndex++];
    //    }
    //  }
    //
    //}


    //Method 2: minHeap I (offline)
    //Time: O(n log n)
    //Space: O(n)
    //public class Solution {
    //  public int[] kSmallest(int[] array, int k) {
    //    int[] result = new int[k];
    //    if (array.length == 0 || k == 0) {
    //      return result;
    //    }
    //    Queue<Integer> pq = new PriorityQueue<>();
    //    for (int i = 0; i < array.length; i++) {
    //      pq.offer(array[i]);
    //    }
    //    for (int i = 0; i < k; i++) {
    //      result[i] = pq.poll();
    //    }
    //    return result;
    //  }
    //}



    //Method 2: minHeap II (offline)
    //Time: O(n) heapify
    //Space: O(n)
    //public class Solution {
    //  public int[] kSmallest(int[] array, int k) {
    //    int[] result = new int[k];
    //    if (array.length == 0 || k == 0) {
    //      return result;
    //    }
    //    List<Integer> list = new ArrayList<>();
    //    for (int i = 0; i < array.length; i++) {
    //      list.add(array[i]);
    //    }
    //    Queue<Integer> pq = new PriorityQueue<>(list);
    //    for (int i = 0; i < k; i++) {
    //      result[i] = pq.poll();
    //    }
    //    return result;
    //  }
    //}


    //Method 3: maxHeap (online)
    //Time: O(k log k + (n - k)log k) = O(n log k)
    //Space: O(k)
    //public class Solution {
    //  public int[] kSmallest(int[] array, int k) {
    //    int[] result = new int[k];
    //    if (array.length == 0 || k == 0) {
    //      return result;
    //    }
    //    Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    //    for (int i = 0; i < k; i++) {
    //      pq.offer(array[i]);
    //    }
    //    for (int i = k; i < array.length; i++) {
    //      if (array[i] < pq.peek()) {
    //        pq.poll();
    //        pq.offer(array[i]);
    //      }
    //    }
    //    for (int i = k - 1; i >= 0; i--) {
    //      result[i] = pq.poll();
    //    }
    //    return result;
    //  }
    //}


    //Method 4: QuickSelect
    //Time: O(n^2)  average: O(n)
    //Space: O(n)   average: O(log n)
    public class Solution {
        public int[] kSmallest(int[] array, int k) {
            int[] result = new int[k];
            if (array.length == 0 || k == 0) {
                return result;
            }
            QuickSelect(array, 0, array.length - 1, k);
            for (int i = 0; i < k; i++) {
                result[i] = array[i];
            }
            Arrays.sort(result);
            return result;
        }

        private void QuickSelect(int[] array, int left, int right, int k) {
            //base case
            if (left >= right) {
                return;
            }
            //recursion rule
            int pivotIndex = left + (int)(Math.random() * (right - left + 1));
            int pivot = array[pivotIndex];
            swap(array, pivotIndex, right);
            int i = left;
            int j = right - 1;
            while (i <= j) {
                if (array[i] < pivot) {
                    i++;
                } else {
                    swap(array, i, j);
                    j--;
                }
            }
            swap(array, i, right);
            if (i < k) {
                QuickSelect(array, i + 1, right, k);
            } else {
                QuickSelect(array, left, i - 1, k);
            }
        }

        private void swap(int[] array, int i, int j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

    }
}
