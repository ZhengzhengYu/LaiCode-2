public class LaiCode105LargestXOf1s {
    //Solution: DP
    //Step1: maintian 4 matrixes, M1, M2, M3, M4
    //M1[i][j] represents the length of longest contigous 1s from left top corner to [i][j], [0][0] to [i][j]
    //M2[i][j] represents the length of longest contigous 1s from right top corner to [i][j], [0][matrix[0].length - 1] to [i][j]
    //M3[i][j] represents the length of longest contigous 1s from left bottom corner to [i][j], [matrix.length - 1][j] to [i][j]
    //M4[i][j] represents the length of longest contigous 1s from right bottom corner to [i][j], [matrix.length - 1][matrix[0].length - 1] to [i][j]
    //Step2: check 4 directions leftTop, rightTop, leftBottom, rightBottom, and get the arm
    //arm = min(leftTop, rightTop, leftBottom, rightBottom);
    public int largest(int[][] matrix) {
        // Write your solution here
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] M1 = new int[matrix.length][matrix[0].length];
        leftTop(matrix, M1);
        int[][] M2 = new int[matrix.length][matrix[0].length];
        rightTop(matrix, M2);
        int[][] M3 = new int[matrix.length][matrix[0].length];
        leftBottom(matrix, M3);
        int[][] M4 = new int[matrix.length][matrix[0].length];
        rightBottom(matrix, M4);

        int global_max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int arm = Math.min(M1[i][j], M2[i][j]);
                arm = Math.min(arm, M3[i][j]);
                arm = Math.min(arm, M4[i][j]);
                if (arm > global_max) {
                    global_max = arm;
                }
            }
        }
        return global_max;
    }

    private void leftTop(int[][] matrix, int[][] M1) {
        for (int j = 0; j < matrix[0].length; j++) {
            M1[0][j] = matrix[0][j];
        }
        for (int i = 0; i < matrix.length; i++) {
            M1[i][0] = matrix[i][0];
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                M1[i][j] = matrix[i][j] == 0 ? 0 : M1[i - 1][j - 1] + 1;
            }
        }
    }

    private void rightTop(int[][] matrix, int[][] M2) {
        for (int j = 0; j < matrix[0].length; j++) {
            M2[0][j] = matrix[0][j];
        }
        for (int i = 0; i < matrix.length; i++) {
            M2[i][matrix[0].length - 1] = matrix[i][matrix[0].length - 1];
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = matrix[0].length - 2; j >= 0; j--) {
                M2[i][j] = matrix[i][j] == 0 ? 0 : M2[i - 1][j + 1] + 1;
            }
        }
    }

    private void leftBottom(int[][] matrix, int[][] M3) {
        for (int i = 0; i < matrix.length; i++) {
            M3[i][0] = matrix[i][0];
        }
        for (int j = 0; j < matrix[0].length; j++) {
            M3[matrix.length - 1][j] = matrix[matrix.length - 1][j];
        }
        for (int i = matrix.length - 2; i >= 0; i--) {
            for (int j = 1; j < matrix[0].length; j++) {
                M3[i][j] = matrix[i][j] == 0 ? 0 : M3[i + 1][j - 1] + 1;
            }
        }
    }

    private void rightBottom(int[][] matrix, int[][] M4) {
        for (int i = 0; i < matrix.length; i++) {
            M4[i][matrix[0].length - 1] = matrix[i][matrix[0].length - 1];
        }
        for (int j = 0; j < matrix[0].length; j++) {
            M4[matrix.length - 1][j] = matrix[matrix.length - 1][j];
        }
        for (int i = matrix.length - 2; i >= 0; i--) {
            for (int j = matrix[0].length - 2; j >= 0; j--) {
                M4[i][j] = matrix[i][j] == 0 ? 0 : M4[i + 1][j + 1] + 1;
            }
        }
    }
}
