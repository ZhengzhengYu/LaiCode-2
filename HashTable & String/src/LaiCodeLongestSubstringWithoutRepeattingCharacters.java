import java.util.*;
public class LaiCodeLongestSubstringWithoutRepeattingCharacters {
    //Method 1: HashMap
    //Time: O(n)
    //Space: O(n)
//    public class Solution {
//      public int longest(String input) {
//        // Write your solution here
//        char[] array = input.toCharArray();
//        Map<Character, Integer> map = new HashMap<>();
//        int global_max = 0;
//        int slow = 0;
//        for (int fast = 0; fast < array.length; fast++) {
//          if (!map.containsKey(array[fast])) {
//            map.put(array[fast], fast);
//            global_max = Math.max(global_max, fast - slow + 1);
//          } else {
//            slow = map.get(array[fast]) + 1;
//            map.put(array[fast], fast);
//          }
//        }
//        return global_max;
//      }
//    }


    //Method 2: HashSet
    //Time: O(n)
    //Space: O(n)
    public class Solution {
        public int longest(String input) {
            // Write your solution here
            char[] array = input.toCharArray();
            Set<Character> set = new HashSet<>();
            int slow = 0;
            int fast = 0;
            int global_max = 0;
            while (fast < array.length) {
                if (set.contains(array[fast])) {
                    set.remove(array[slow++]);
                } else {
                    set.add(array[fast++]);
                    global_max = Math.max(global_max, fast - slow);
                }
            }
            return global_max;
        }
    }

}
