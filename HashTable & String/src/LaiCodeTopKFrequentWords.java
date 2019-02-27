import java.util.*;

public class LaiCodeTopKFrequentWords {
    //Time: on everage O(n) + O(n log k) + O(k) = O(n log k)
    //Space: O(n)
    public class Solution {
        public String[] topKFrequent(String[] combo, int k) {
            // Write your solution here
            if (combo.length == 0) {
                return new String[0];
            }
            //Time: on everage O(n)  worse case: O(n^2)
            HashMap<String, Integer> freqMap = getFreq(combo);
            PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                    if (e1.getValue() > e2.getValue()) {
                        return 1;
                    } else if (e1.getValue() < e2.getValue()) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            });
            //Time: O(n log k)
            for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
                if (minHeap.size() < k) {
                    minHeap.offer(entry);
                } else {
                    if (entry.getValue() > minHeap.peek().getValue()) {
                        minHeap.poll();
                        minHeap.offer(entry);
                    }
                }
            }
            //Time: O(k)
            return freqArray(minHeap);
        }

        private HashMap<String, Integer> getFreq(String[] combo) {
            HashMap<String, Integer> freqMap = new HashMap<>();
            for (String s : combo) {
                Integer value = freqMap.get(s);
                if (value == null) {
                    freqMap.put(s, 1);
                } else {
                    freqMap.put(s, value + 1);
                }
            }
            return freqMap;
        }

        private String[] freqArray(PriorityQueue<Map.Entry<String, Integer>> minHeap) {
            String[] result = new String[minHeap.size()];
            for (int i = minHeap.size() - 1; i >= 0; i--) {
                result[i] = minHeap.poll().getKey();
            }
            return result;
        }
    }

}
