import java.util.ArrayList;
import java.util.List;

public class LaiCode122SpiralOrderTraverseII {
    //Method 1: Recursive way
    //Time: O(n^2)
    //Space: O(n)
    public List<Integer> spiral(int[][] matrix) {
        // Write your solution here
        List<Integer> result = new ArrayList<>();
        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        helper(matrix, up, down, left, right, result);
        return result;
    }

    private void helper(int[][] matrix, int up, int down, int left, int right, List<Integer> result) {
        //base case
        if (left > right || up > down) {
            return;
        }
        if (left == right) {
            for (int i = up; i <= down; i++) {
                result.add(matrix[i][left]);
            }
            return;
        }
        if (up == down) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[up][i]);
            }
            return;
        }
        //recursion rule
        for (int i = left; i < right; i++) {
            result.add(matrix[up][i]);
        }
        for (int i = up; i < down; i++) {
            result.add(matrix[i][right]);
        }
        for (int i = right; i > left; i--) {
            result.add(matrix[down][i]);
        }
        for (int i = down; i > up; i--) {
            result.add(matrix[i][left]);
        }
        //subproblem
        helper(matrix, up + 1, down - 1, left + 1, right - 1, result);
    }

    //Method 2: Iterative way
    //Time: O(n^2)
    //Space: O(1)
//    public List<Integer> spiral(int[][] matrix) {
//        // Write your solution here
//        List<Integer> result = new ArrayList<>();
//        int left = 0;
//        int right = matrix[0].length - 1;
//        int up = 0;
//        int down = matrix.length - 1;
//        while (left < right && up < down) {
//            for (int i = left; i <= right; i++) {
//                result.add(matrix[up][i]);
//            }
//            for (int i = up + 1; i <= down - 1; i++) {
//                result.add(matrix[i][right]);
//            }
//            for (int i = right; i >= left; i--) {
//                result.add(matrix[down][i]);
//            }
//            for (int i = down - 1; i >= up + 1; i--) {
//                result.add(matrix[i][left]);
//            }
//            left++;
//            right--;
//            up++;
//            down--;
//        }
//        //if there is something left
//        if (left > right || up > down) {
//            return result;
//        }
//        if (left == right) {
//            for (int i = up; i <= down; i++) {
//                result.add(matrix[i][left]);
//            }
//        }else if (up == down) {
//            for (int i = left; i <= right; i++) {
//                result.add(matrix[up][i]);
//            }
//        }
//        return result;
//    }


}
