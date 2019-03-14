import java.util.*;

public class LaiCode233NQueens {
    //Method 1 check isValid is O(n)
    //Time: O(n^n)
    //Space: O(n)
//    public List<List<Integer>> nqueens(int n) {
//        // Write your solution here
//        List<List<Integer>> result = new ArrayList<>();
//        List<Integer> cur = new ArrayList<>();
//        helper(n, cur, result);
//        return result;
//    }
//
//    private void helper(int n, List<Integer> cur, List<List<Integer>> result) {
//        //base case
//        if (cur.size() == n) {
//            result.add(new ArrayList<>(cur));
//            return;
//        }
//        //n branches in each level
//        for (int i = 0; i < n; i++) {
//            //check if put a queen at col i at cur row is valid
//            if (isValid(cur, i)) {
//                cur.add(i);
//                helper(n, cur, result);
//                cur.remove(cur.size() - 1);
//            }
//        }
//    }
//
//    //check the queen at col at cur row if has same col and same slope y = x or y = -x
//    //compare with each queen before the current row
//    private boolean isValid(List<Integer> cur, int col) {
//        int curRow = cur.size();
//        for (int i = 0; i < curRow; i++) {
//            if (cur.get(i) == col || Math.abs(cur.get(i) - col) == curRow - i) {
//                return false;
//            }
//        }
//        return true;
//    }

    //Method 2: check isValid is O(1)
    //Time: O(n^n)
    //Space: O(n)
    public List<List<Integer>> nqueens(int n) {
        // Write your solution here
        List<List<Integer>> result = new ArrayList<>();
        //cur will be a list of size n, and cur[i] is the colum number where the queen on row i positioned.
        int[] cur = new int[n];
        //record on which colums there is already a queen
        boolean[] usedColumns = new boolean[n];
        //record on which diagonal lines there is already a queen
        boolean[] usedDiagonals = new boolean[2 * n - 1];
        //record on which reverse diagonal lines there is already a queen
        boolean[] usedRevDiagonals = new boolean[2 * n - 1];
        helper(n, 0, cur, result, usedColumns, usedDiagonals, usedRevDiagonals);
        return result;
    }

    private void helper(int n, int row, int[] cur, List<List<Integer>> result, boolean[] usedColumns, boolean[] usedDiagonals, boolean[] usedRevDiagonals) {
        //base case
        if (row == n) {
            result.add(toList(cur));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(n, row, i, usedColumns, usedDiagonals, usedRevDiagonals)) {
                mark(n, row, i, usedColumns, usedDiagonals, usedRevDiagonals);
                cur[row] = i;
                helper(n, row + 1, cur, result, usedColumns, usedDiagonals, usedRevDiagonals);
                unMark(n, row, i, usedColumns, usedDiagonals, usedRevDiagonals);
            }
        }
    }

    private boolean isValid(int n, int row, int column, boolean[] usedColumns, boolean[] usedDiagonals, boolean[] usedRevDiagonals) {
        return !usedColumns[column] && !usedDiagonals[row + column] && !usedRevDiagonals[column - row + n - 1];
    }

    private void mark(int n, int row, int colum, boolean[] usedColums, boolean[] usedDiagonals, boolean[] usedRevDiagonals) {
        usedColums[colum] = true;
        usedDiagonals[row + colum] = true;
        usedRevDiagonals[colum - row + n - 1] = true;
    }

    private void unMark(int n, int row, int column, boolean[] usedColumns, boolean[] usedDiagonals, boolean[] usedRevDiagonals) {
        usedColumns[column] = false;
        usedDiagonals[row + column] = false;
        usedRevDiagonals[column - row + n - 1] = false;
    }

    private List<Integer> toList(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int num : array) {
            list.add(num);
        }
        return list;
    }

}
