public class LaiCode124SpiralOrderGenerateII {
    //Method 1: Recursive way
    //Time: O(m*n)
    //Space: O(Math.max(m,n))
//    public int[][] spiralGenerate(int m, int n) {
//        // Write your solution here
//        int[][] matrix = new int[m][n];
//        //matrix, up, down, left, right, counter
//        helper(matrix, 0, m - 1, 0, n - 1, 1);
//        return matrix;
//    }
//    private void helper(int[][] matrix, int up, int down, int left, int right, int counter) {
//        //base case
//        if (left > right || up > down) {
//            return;
//        }
//        if (left == right) {
//            for (int i = up; i <= down; i++) {
//                matrix[i][left] = counter++;
//            }
//            return;
//        }
//        if (up == down) {
//            for (int i = left; i <= right; i++) {
//                matrix[up][i] = counter++;
//            }
//            return;
//        }
//        //recursion rule
//        for (int i = left; i < right; i++) {
//            matrix[up][i] = counter++;
//        }
//        for (int i = up; i < down; i++) {
//            matrix[i][right] = counter++;
//        }
//        for (int i = right; i > left; i--) {
//            matrix[down][i] = counter++;
//        }
//        for (int i = down; i > up; i--) {
//            matrix[i][left] = counter++;
//        }
//        //subproblem
//        helper(matrix, up + 1, down - 1, left + 1, right - 1, counter);
//    }



    //Method 2:Iterative way
    //Time: O(m*n)
    //Space: O(1)
    public int[][] spiralGenerate(int m, int n) {
        // Write your solution here
        int[][] matrix = new int[m][n];
        int up = 0;
        int down = m - 1;
        int left = 0;
        int right = n - 1;
        int counter = 1;
        while (left < right && up < down) {
            for (int i = left; i <= right; i++) {
                matrix[up][i] = counter++;
            }
            for (int i = up + 1; i <= down - 1; i++) {
                matrix[i][right] = counter++;
            }
            for (int i = right; i >= left; i--) {
                matrix[down][i] = counter++;
            }
            for (int i = down - 1; i >= up + 1; i--) {
                matrix[i][left] = counter++;
            }
            up++;
            down--;
            left++;
            right--;
        }
        if (left > right || up > down) {
            return matrix;
        }
        if (left == right) {
            for (int i = up; i <= down; i++) {
                matrix[i][left] = counter++;
            }
        } else if (up == down) {
            for (int i = left; i <= right; i++) {
                matrix[up][i] = counter++;
            }
        }
        return matrix;
    }
}
