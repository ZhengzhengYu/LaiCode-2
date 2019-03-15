import java.util.ArrayList;
import java.util.List;

public class LaiCode121SpiralOrderTraverseI {
    //Method 1: Recursive way
    //Time: O(n^2)
    //Space: O(n)
//  public List<Integer> spiral(int[][] matrix) {
//    // Write your solution here
//    List<Integer> result = new ArrayList<>();
//    helper(matrix, 0, matrix.length, result);
//    return result;
//  }
//  //offset是偏移量，计算坐标位置的时候可以通过上下左右的偏移量来考虑
//  private void helper(int[][] matrix, int offset, int size, List<Integer> result) {
//    if (size == 0) {
//      return;
//    }
//    if (size == 1) {
//      result.add(matrix[offset][offset]);
//      return;
//    }
//    for (int i = 0; i < size - 1; i++) {
//      result.add(matrix[offset][i + offset]);
//    }
//    for (int i = 0; i < size - 1; i++) {
//      result.add(matrix[i + offset][offset + size - 1]);
//    }
//    for (int i = size - 1; i >= 1; i--) {
//      result.add(matrix[offset + size - 1][i + offset]);
//    }
//    for (int i = size - 1; i >= 1; i--) {
//      result.add(matrix[offset + i][offset]);
//    }
//    helper(matrix, offset + 1, size - 2, result);
//  }


    //Method 2:Itervative way
    //Time: O(n^2)
    //Space: O(n)
    public List<Integer> spiral(int[][] matrix) {
        // Write your solution here
        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = matrix.length - 1;
        while (start < end) {
            for (int i = start; i <= end; i++) {
                result.add(matrix[start][i]);
            }
            for (int i = start + 1; i <= end - 1; i++) {
                result.add(matrix[i][end]);
            }
            for (int i = end; i >= start; i--) {
                result.add(matrix[end][i]);
            }
            for (int i = end - 1; i >= start + 1; i--) {
                result.add(matrix[i][start]);
            }
            start++;
            end--;
        }
        if (start == end) {
            result.add(matrix[start][end]);
        }
        return result;
    }
}
