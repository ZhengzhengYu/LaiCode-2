import java.util.*;

public class LaiCodeAllPermutationsI {
    //Time: O(n!)
    //Space:O(n)
    public class Solution {
        public List<String> permutations(String set) {
            // Write your solution here
            List<String> result = new ArrayList<>();
            if (set == null) {
                return result;
            }
            char[] setArray = set.toCharArray();
            helper(setArray, 0, result);
            return result;
        }

        private void helper(char[] setArray, int index, List<String> result) {
            if (index == setArray.length) {
                result.add(new String(setArray));
                return;
            }
            for (int i = index; i < setArray.length; i++) {
                swap(setArray, index, i);
                helper(setArray, index + 1, result);
                swap(setArray, index, i);
            }
        }

        private void swap(char[] setArray, int i, int j) {
            char temp = setArray[i];
            setArray[i] = setArray[j];
            setArray[j] = temp;

        }
    }

}
