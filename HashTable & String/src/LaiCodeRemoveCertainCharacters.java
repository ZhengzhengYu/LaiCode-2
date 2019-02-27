import java.util.*;

public class LaiCodeRemoveCertainCharacters {
    //Method 1
    //Time: O(n * m)  n = input.length();  m = t.length();
    //Space: O(n)
    //public class Solution {
    //  public String remove(String input, String t) {
    //    // Write your solution here
    //    if (input.length() == 0 || t.length() == 0) {
    //      return input;
    //    }
    //    char[] inputArray = input.toCharArray();
    //    char[] tArray = t.toCharArray();
    //    int fast = 0;
    //    int slow = 0;
    //    while (fast < inputArray.length) {
    //      if (!containsDelete(inputArray, tArray, fast)) {
    //        inputArray[slow++] = inputArray[fast];
    //      }
    //      fast++;
    //    }
    //    return new String(inputArray, 0, slow);
    //  }
    //
    //  private boolean containsDelete(char[] inputArray, char[] tArray, int fast) {
    //    for (int i = 0; i < tArray.length; i++) {
    //      if (inputArray[fast] == tArray[i]) {
    //        return true;
    //      }
    //    }
    //    return false;
    //  }
    //}


    //Method 2
    //Time: O(n * m)  n = input.length();  m = t.length();
    //Space: O(n)
    public class Solution {
        public String remove(String input, String t) {
            // Write your solution here
            if (input.length() == 0 || t.length() == 0) {
                return input;
            }
            char[] inputArray = input.toCharArray();
            HashSet<Character> set = buildSet(t);
            int slow = 0;
            for (int fast = 0; fast < inputArray.length; fast++) {
                if (!set.contains(inputArray[fast])) {
                    inputArray[slow++] = inputArray[fast];
                }
            }
            return new String(inputArray, 0, slow);
        }

        private HashSet<Character> buildSet(String t) {
            char[] tArray = t.toCharArray();
            HashSet<Character> set = new HashSet();
            for (int i = 0; i < tArray.length; i++) {
                set.add(tArray[i]);
            }
            return set;
        }

    }

}
