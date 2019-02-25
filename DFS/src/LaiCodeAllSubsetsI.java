import java.util.ArrayList;
import java.util.List;

public class LaiCodeAllSubsetsI {
    //Time: O(2^n)
    //Space: O(n)
    public class Solution {
        public List<String> subSets(String set) {
            // Write your solution here.
            List<String> result = new ArrayList<>();
            if (set == null) {
                return result;
            }
            char[] setArray = set.toCharArray();
            StringBuilder sb = new StringBuilder();
            helper(setArray, 0, sb, result);
            return result;
        }

        private void helper(char[] setArray, int index, StringBuilder sb, List<String> result) {
            if (index == setArray.length) {
                result.add(sb.toString());
                return;
            }
            //case 1:add
            sb.append(setArray[index]);
            helper(setArray, index + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
            //case 2: not add
            helper(setArray, index + 1, sb, result);
        }
    }

}
