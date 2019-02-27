import java.util.*;
public class LaiCodeCommonNumbersOfTwoSortedArrays {
    //Method 1: HashMap
    //Time: on everage O(max(n, m)), worse case O(n * m)
    //Space: O(min(n, m))
    //n = A.length(); m = B.length();
    //public class Solution {
    //  public List<Integer> common(List<Integer> A, List<Integer> B) {
    //    // Write your solution here
    //    List<Integer> result = new ArrayList<>();
    //    HashMap<Integer, Integer> map = new HashMap<>();
    //    for (Integer number : A) {
    //      Integer value = map.get(number);
    //      if (value == null) {
    //        map.put(number, 1);
    //      } else {
    //        map.put(number, value + 1);
    //      }
    //    }
    //    for (Integer number : B) {
    //      Integer value = map.get(number);
    //      if (value != null && value >= 1) {
    //        map.put(number, value - 1);
    //        result.add(number);
    //      }
    //    }
    //    return result;
    //  }
    //}


    //Method 2: two pointer谁小移谁
    //Time: O(n + m)
    //Space: O(n + m)
    public class Solution {
        public List<Integer> common(List<Integer> A, List<Integer> B) {
            // Write your solution here
            List<Integer> result = new ArrayList<>();
            Integer[] aArray = new Integer[A.size()];
            aArray = A.toArray(aArray);
            Integer[] bArray = new Integer[B.size()];
            bArray = B.toArray(bArray);
            int i = 0;
            int j = 0;
            while (i < aArray.length && j < bArray.length) {
                if (aArray[i] == bArray[j]) {
                    result.add(aArray[i]);
                    i++;
                    j++;
                } else if (aArray[i] < bArray[j]) {
                    i++;
                } else {
                    j++;
                }
            }
            return result;
        }
    }


}
