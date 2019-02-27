import java.util.*;

public class LaiCodeMissingNumberI {
    //Method 1: HashSet
    //Time: on everage O(n)  worse case: O(n^2)
    //Space: O(n)
    //public class Solution {
    //  public int missing(int[] array) {
    //    // Write your solution here
    //    if (array.length == 0) {
    //      return 1;
    //    }
    //    int n = array.length + 1;
    //    HashSet<Integer> set = new HashSet<>();
    //    for (int number : array) {
    //      set.add(number);
    //    }
    //    for (int i = 1; i < n; i++) {
    //      if (!set.contains(i)) {
    //        return i;
    //      }
    //    }
    //    return n;
    //  }
    //}



    //Method 2: boolean[] array
    //Time: O(n)
    //Space: O(n)
    public class Solution {
        public int missing(int[] array) {
            // Write your solution here
            if (array.length == 0) {
                return 1;
            }
            boolean[] occurred = new boolean[array.length + 1];
            for (int number : array) {
                occurred[number - 1] = true;
            }
            for (int i = 1; i <= occurred.length; i++) {
                if (!occurred[i - 1]) {
                    return i;
                }
            }
            return -1;
        }
    }


    //Method 3: sum
    //Time: O(n)
    //Space: O(1)
    //public class Solution {
    //  public int missing(int[] array) {
    //    // Write your solution here
    //    if (array.length == 0) {
    //      return 1;
    //    }
    //    int n = array.length + 1;
    //    Long targetSum = (1L + n) * n / 2;
    //    Long actSum = 0L;
    //    for (int number : array) {
    //      actSum += number;
    //    }
    //    return (int)(targetSum - actSum);
    //  }
    //}



    //Method 4: Bit
    //Time: O(n)
    //Space: O(1)
    //public class Solution {
    //  public int missing(int[] array) {
    //    // Write your solution here
    //    if (array.length == 0) {
    //      return 1;
    //    }
    //    int xor = 0;
    //    for (int number : array) {
    //      xor ^= number;
    //    }
    //    for (int i = 1; i <= array.length + 1; i++) {
    //      xor ^= i;
    //    }
    //    return xor;
    //  }
    //}


}
