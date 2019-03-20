public class LaiCodeLongestCrossOf1s {
    //Solution: DP
    //Step1: maintains 4 matrixes
    //M1[i][j] represents from left to right, the length of longest contigous 1s with [i][j] as center;
    //M2[i][i] represents from right to left, the length of longest contigous 1s with [i][j] as center;
    //M3[i][j] represents from bottom to up, the length of longest contigous 1s with [i][j] as center;
    //M4[i][j] represents from up to bottom, the length of longest contigous 1s with [i][j] as center;
    //check 4 directions: up, down, left and right to get the length of longest contigious 1s with [i][j] as center;
    //the length of arm = min(up, down, left, right);
    //maintain a global_max

    //Time: O(n^2)
    //Space: O(n^2)
    public int largest(int[][] matrix) {
        // Write your solution here
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] M1 = new int[matrix.length][matrix[0].length];
        leftToRight(matrix, M1);
        int[][] M2 = new int[matrix.length][matrix[0].length];
        rightToLeft(matrix, M2);
        int[][] M3 = new int[matrix.length][matrix[0].length];
        bottomToUp(matrix, M3);
        int[][] M4 = new int[matrix.length][matrix[0].length];
        upToBottom(matrix, M4);
        int global_max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int arm = 0;
                int left = M1[i][j];
                int right = M2[i][j];
                arm = Math.min(left, right);
                int bottom = M3[i][j];
                arm = Math.min(arm, bottom);
                int up = M4[i][j];
                arm = Math.min(arm, up);
                if (arm > global_max) {
                    global_max = arm;
                }
            }
        }
        return global_max;
    }

    private void leftToRight(int[][] matrix, int[][] M1) {
        for (int i = 0; i < matrix.length; i++) {
            M1[i][0] = matrix[i][0];
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                M1[i][j] = matrix[i][j] == 0 ? 0 : M1[i][j - 1] + 1;
            }
        }
    }

    private void rightToLeft(int[][] matrix, int[][] M2) {
        for (int i = 0; i < matrix.length; i++) {
            M2[i][matrix[0].length - 1] = matrix[i][matrix[0].length - 1];
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = matrix[0].length - 2; j >= 0; j--) {
                M2[i][j] = matrix[i][j] == 0 ? 0 : M2[i][j + 1] + 1;
            }
        }
    }

    private void bottomToUp(int[][] matrix, int[][] M3) {
        for (int j = 0; j < matrix[0].length; j++) {
            M3[matrix.length - 1][j] = matrix[matrix.length - 1][j];
        }
        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = matrix.length - 2; i >= 0; i--) {
                M3[i][j] = matrix[i][j] == 0 ? 0 : M3[i + 1][j] + 1;
            }
        }
    }

    private void upToBottom(int[][] matrix, int[][] M4) {
        for (int j = 0; j < matrix[0].length; j++) {
            M4[0][j] = matrix[0][j];
        }
        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = 1; i < matrix.length; i++) {
                M4[i][j] = matrix[i][j] == 0 ? 0 : M4[i - 1][j] + 1;
            }
        }
    }
}
