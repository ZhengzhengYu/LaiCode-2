import java.util.*;
//Time: O(2^2n)
//Space: O(n)
public class ParenthesesI {
    public List<String> generate(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        helper(n,0, 0, sb, result);
        return result;
    }

    private void helper(int n, int l, int r, StringBuilder sb, List<String> result) {
        if (l == n && r == n) {
            result.add(sb.toString());
            return;
        }
        if (l < n) {
            sb.append('(');
            helper(n, l + 1, r, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (r < l) {
            sb.append(')');
            helper(n, l, r + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
