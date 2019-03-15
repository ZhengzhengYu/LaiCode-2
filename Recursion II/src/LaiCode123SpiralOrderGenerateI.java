public class LaiCode123SpiralOrderGenerateI {
//Method 1: Recursive way
    //Time: O(n^2)
    //Space:O(n)
    //n = input n
//    public int[][] spiralGenerate(int n) {
//        // Write your solution here
//        int[][] matrix = new int[n][n];
//        helper(matrix, 0, n, 1);
//        return matrix;
//    }
//
//    private void helper(int[][] matrix, int offset, int size, int counter) {
//        //base case
//        if (size == 0) {
//            return;
//        }
//        if (size == 1) {
//            matrix[offset][offset] = counter++;
//            return;
//        }
//        //recursion rule
//        for (int i = 0; i < size - 1; i++) {
//            matrix[offset][offset + i] = counter++;
//        }
//        for (int i = 0; i < size - 1; i++) {
//            matrix[i + offset][offset + size - 1] = counter++;
//        }
//        for (int i = size - 1; i > 0; i--) {
//            matrix[offset + size - 1][offset + i] = counter++;
//        }
//        for (int i = size - 1; i > 0; i--) {
//            matrix[offset + i][offset] = counter++;
//        }
//        //subproblem
//        helper(matrix, offset + 1, size - 2, counter);
//    }

    //Method 2: Iterative way
    //Time: O(n^2)
    //Space: O(1)
    //n = input n
    public int[][] spiralGenerate(int n) {
        int[][] matrix = new int[n][n];
        int start = 0;
        int end = n - 1;
        int counter = 1;
        while (start < end) {
            for (int i = start; i <= end; i++) {
                matrix[start][i] = counter++;
            }
            for (int i = start + 1; i <= end - 1; i++) {
                matrix[i][end] = counter++;
            }
            for (int i = end; i >= start; i--) {
                matrix[end][i] = counter++;
            }
            for (int i = end - 1; i >= start + 1; i--) {
                matrix[i][start] = counter++;
            }
            start++;
            end--;
        }
        if (start == end) {
            matrix[start][end] = counter;
        }
        return matrix;
    }

}
