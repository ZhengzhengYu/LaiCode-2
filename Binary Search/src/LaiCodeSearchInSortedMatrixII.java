public class LaiCodeSearchInSortedMatrixII {
    //Method:从右上角开始找
    //Time: O(m + n)
    //m = matrix.length; n = matrix[0].length
    //Space: O(1)
    public class Solution {
        public int[] search(int[][] matrix, int target) {
            // Write your solution here
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return new int[] {-1, -1};
            }
            int row = 0;
            int col = matrix[0].length - 1;
            while (row <= matrix.length - 1 && col >= 0) {
                if (matrix[row][col] == target) {
                    return new int[] {row, col};
                } else if (matrix[row][col] > target) {
                    col--;
                } else {
                    row++;
                }
            }
            return new int[] {-1, -1};
        }
    }

}
