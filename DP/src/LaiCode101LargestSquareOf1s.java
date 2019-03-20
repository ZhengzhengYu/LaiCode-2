//Time: O(m*n)
//Space:O(m*n)
public class LaiCode101LargestSquareOf1s {
    public int largest(int[][] matrix) {
        // Write your solution here
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int global_max = 0;
        //M[i][j] represents the max size of square with (i, j) as the bottom-right corner.
        int[][] M = new int[matrix.length][matrix[0].length];
        //base case
        for (int j = 0; j < M[0].length; j++) {
            M[0][j] = matrix[0][j];
            global_max  = Math.max(global_max, M[0][j]);
        }
        for (int i = 0; i < M.length; i++) {
            M[i][0] = matrix[i][0];
            global_max = Math.max(global_max, M[i][0]);
        }

        //induction rule
        for (int i = 1; i < M.length; i++) {
            for (int j = 1; j < M[0].length; j++) {
                if (matrix[i][j] == 1) {
                    M[i][j] = Math.min(M[i - 1][j] + 1, M[i][j - 1] + 1);
                    M[i][j] = Math.min(M[i][j], M[i - 1][j - 1] + 1);
                    global_max = Math.max(global_max, M[i][j]);
                }
            }
        }
        return global_max;
    }
}
