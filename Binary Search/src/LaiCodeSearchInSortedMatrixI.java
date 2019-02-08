//Method 1 find row first then find col.
//Time: O(log m + log n) = O(log m*n)
//Space: O(1)
public class LaiCodeSearchInSortedMatrixI {
    public class Solution {
        public int[] search(int[][] matrix, int target) {
            // Write your solution here
            int[] result = new int[] {-1, -1};
            if (matrix == null || matrix.length == 0) {
                return new int[] {-1, -1};
            }
            int n = matrix.length;
            int m = matrix[0].length;

            int row = findRow(matrix, 0, n - 1, target);
            if (row == -1) {
                return new int[] {-1, -1};
            }
            int col = findCol(matrix[row], 0, m - 1, target);
            if (col == -1) {
                return new int[] {-1, -1};
            }
            return new int[] {row, col};
        }

        private int findRow(int[][] matrix, int up, int bottom, int target) {
            while (up <= bottom) {
                int mid = up + (bottom - up) / 2;
                if (matrix[mid][0] == target) {
                    return mid;
                } else if (matrix[mid][0] > target) {
                    bottom = mid - 1;
                } else {
                    up = mid + 1;
                }
            }
            return bottom;
        }

        private int findCol(int[] array, int left, int right, int target) {
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (array[mid] == target) {
                    return mid;
                } else if (array[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return -1;
        }

    }

//    public class Solution {
//      public int[] search(int[][] matrix, int target) {
//        // Write your solution here
//        int[] result = new int[] {-1, -1};
//        if (matrix == null || matrix.length == 0) {
//          return new int[] {-1, -1};
//        }
//        int n = matrix.length;
//        int m = matrix[0].length;
//
//        int row = findRow(matrix, 0, n - 1, target);
//        if (row == -1) {
//          return new int[] {-1, -1};
//        }
//        int col = findCol(matrix[row], 0, m - 1, target);
//        if (col == -1) {
//          return new int[] {-1, -1};
//        }
//        return new int[] {row, col};
//      }
//
//      private int findRow(int[][] matrix, int up, int bottom, int target) {
//        while (up + 1 < bottom) {
//          int mid = up + (bottom - up) / 2;
//          if (matrix[mid][0] == target) {
//            return mid;
//          } else if (matrix[mid][0] > target) {
//            bottom = mid;
//          } else {
//            up = mid;
//          }
//        }
//
//        if (matrix[bottom][0] == target) {
//          return bottom;
//        }
//        if(matrix[up][0] == target) {
//          return up;
//        }
//        if (matrix[bottom][0] < target) {
//          return bottom;
//        }
//        if (matrix[up][0] < target) {
//          return up;
//        }
//        return -1;
//      }
//
//      private int findCol(int[] array, int left, int right, int target) {
//        while (left + 1 < right) {
//          int mid = left + (right - left) / 2;
//          if (array[mid] == target) {
//            return mid;
//          } else if (array[mid] > target) {
//            right = mid;
//          } else {
//            left = mid;
//          }
//        }
//        if (array[left] == target) {
//          return left;
//        }
//        if (array[right] == target) {
//          return right;
//        }
//        return -1;
//      }
//
//    }



//Method 2 convert the 2D array to 1D array and do binary search
//Time: O(log m + log n) = O(log m*n)
//Space: O(1)
//    public class Solution {
//      public int[] search(int[][] matrix, int target) {
//        // Write your solution here
//        if (matrix == null || matrix.length == 0) {
//          return new int[] {-1, -1};
//        }
//        int n = matrix.length;
//        int m = matrix[0].length;
//        int left = 0;
//        int right = n * m - 1;
//        while (left <= right) {
//          int mid = left + (right - left) / 2;
//          int row = mid / m;
//          int col = mid % m;
//          if (matrix[row][col] == target) {
//            return new int[] {row, col};
//          } else if (matrix[row][col] > target) {
//            right = mid - 1;
//          } else {
//            left = mid + 1;
//          }
//        }
//        return new int[] {-1, -1};
//      }
//    }



//    public class Solution {
//      public int[] search(int[][] matrix, int target) {
//        // Write your solution here
//        if (matrix == null || matrix.length == 0) {
//          return new int[] {-1, -1};
//        }
//        int n = matrix.length;
//        int m = matrix[0].length;
//        int left = 0;
//        int right = n * m - 1;
//        while (left + 1 < right) {
//          int mid = left + (right - left) / 2;
//          int row = mid / m;
//          int col = mid % m;
//          if (matrix[row][col] == target) {
//            return new int[] {row, col};
//          } else if (matrix[row][col] > target) {
//            right = mid;
//          } else {
//            left = mid;
//          }
//        }
//        int row = left / m;
//        int col = left % m;
//        if (matrix[row][col] == target) {
//          return new int[] {row, col};
//        }
//
//        row = right / m;
//        col = right % m;
//        if (matrix[row][col] == target) {
//          return new int[] {row, col};
//        }
//
//        return new int[] {-1, -1};
//      }
//    }

}
