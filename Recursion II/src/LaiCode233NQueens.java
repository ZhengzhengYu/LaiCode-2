import java.util.*;

public class LaiCode233NQueens {
    //Method 1 check isValid is O(n)
    //Time: O(n^n)
    //Space: O(n)
    public List<List<Integer>> nqueens(int n) {
        // Write your solution here
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper(n, cur, result);
        return result;
    }

    private void helper(int n, List<Integer> cur, List<List<Integer>> result) {
        //base case
        if (cur.size() == n) {
            result.add(new ArrayList<>(cur));
            return;
        }
        //n branches in each level
        for (int i = 0; i < n; i++) {
            //check if put a queen at col i at cur row is valid
            if (isValid(cur, i)) {
                cur.add(i);
                helper(n, cur, result);
                cur.remove(cur.size() - 1);
            }
        }
    }

    //check the queen at col at cur row if has same col and same slope y = x or y = -x
    //compare with each queen before the current row
    private boolean isValid(List<Integer> cur, int col) {
        int curRow = cur.size();
        for (int i = 0; i < curRow; i++) {
            if (cur.get(i) == col || Math.abs(cur.get(i) - col) == curRow - i) {
                return false;
            }
        }
        return true;
    }
}
