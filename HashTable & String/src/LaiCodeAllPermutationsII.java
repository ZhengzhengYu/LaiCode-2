import java.util.*;
public class LaiCodeAllPermutationsII {
    //Time: O(n!)
    //Space: O(n^2)每一层都用了一个set，一共n层
    public class Solution {
        public List<String> permutations(String set) {
            // Write your solution here
            List<String> result = new ArrayList<>();
            if (set == null) {
                return result;
            }
            char[] array = set.toCharArray();
            helper(array, 0, result);
            return result;
        }

        private void helper(char[] array, int index, List<String> result) {
            if (index == array.length) {
                result.add(new String(array));
                return;
            }
            Set<Character> set = new HashSet<>();
            for (int i = index; i < array.length; i++) {
                if (!set.contains(array[i])) {
                    set.add(array[i]);
                    swap(array, index, i);
                    helper(array, index + 1, result);
                    swap(array, index, i);
                }
            }
        }

        private void swap(char[] array, int i, int j) {
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

    }

}
