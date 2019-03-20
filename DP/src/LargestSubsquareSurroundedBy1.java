public class LargestSubsquareSurroundedBy1 {
    //Solution: DP
    //Step1: maintain 2 matrix, M1, M2
    //M1[i][j] represents the length of longest contiguous 1 from the right to left
    //M2[i][j] represents the length of longest contiguous 1 from the bottom to up
    //Step2: for each position check the max size of subsquare
    public int largestSubsquareSurroundedByOne(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] M1 = new int[matrix.length][matrix[0].length];
        rightToLeft(matrix, M1);
        int[][] M2 = new int[matrix.length][matrix[0].length];
        bottomToUp(matrix, M2);

        int size = Math.min(matrix.length, matrix[0].length);
        int global_max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                for (int k = size; k > 0; k--) {
                    if (M1[i][j] == k && M2[i][j] == k && M2[i][j + k - 1] == k && M1[i + k - 1][j] == k) {
                        if (k > global_max) {
                            global_max = k;
                        }
                        break;
                    }
                }
            }
        }
        return global_max;
    }

    private void rightToLeft(int[][] matrix, int[][] M1) {
        for (int i = 0; i < matrix.length; i++) {
            M1[i][matrix[0].length - 1] = matrix[i][matrix[0].length - 1];
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = matrix[0].length - 2; j >= 0; j--) {
                M1[i][j] = matrix[i][j] == 0 ? 0 : M1[i][j + 1] + 1;
            }
        }
    }

    private void bottomToUp(int[][] matrix, int[][] M2) {
        for (int j = 0; j < matrix[0].length; j++) {
            M2[matrix.length - 1][j] = matrix[matrix.length - 1][j];
        }
        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = matrix.length - 2; i >= 0; i--) {
                M2[i][j] = matrix[i][j] == 0 ? 0 : M2[i - 1][j] + 1;
            }
        }

    }
}
