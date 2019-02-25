import java.util.ArrayList;
import java.util.List;

public class LaiCodeAllValidPermutationsOfParenth {
    //Time: O(2^2n)
    //Space:O(n)
    public class Solution {
        public List<String> validParentheses(int n) {
            // Write your solution here
            List<String> result = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            helper(n, 0, 0, sb, result);
            return result;
        }

        //int l: sb has already have l "("
        //int r: sb has already have r ")"
        private void helper(int n, int l, int r, StringBuilder sb, List<String> result) {
            if (l == n && r == n) {
                result.add(sb.toString());
                return;
            }
            //case 1: add "("
            if (l < n) {
                sb.append("(");
                helper(n, l + 1, r, sb, result);
                sb.deleteCharAt(sb.length() - 1);
            }
            //case 2: add ")"
            if (r < l) {
                sb.append(")");
                helper(n, l, r + 1, sb, result);
                sb.deleteCharAt(sb.length() - 1);
            }
        }

    }

}
