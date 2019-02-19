import java.util.ArrayList;
import java.util.List;

public class LaiCodeGetKeysInBinarySearchTreeInGivenRange {
    public class Solution {
        public List<Integer> getRange(TreeNode root, int min, int max) {
            // Write your solution here
            List<Integer> result = new ArrayList<>();
            getRangeHelper(root, min, max, result);
            return result;
        }

      //Method 1
      //Time: O(n)
      //Space: O(height)  worse case: O(n)
//      private void getRangeHelper(TreeNode root, int min, int max, List<Integer> result) {
//        //base case
//        if (root == null) {
//          return;
//        }
//        //subproblem
//        getRangeHelper(root.left, min, max, result);
//        //recursion rule
//        if (root.key >= min && root.key <= max) {
//          result.add(root.key);
//        }
//        //subproblem
//        getRangeHelper(root.right, min, max, result);
//      }

        //Method 2: branch pruning
        //Time: O(height + #node in range[min, max]) worse case: O(n)
        //Space: O(height)  worse case: O(n)
        private void getRangeHelper(TreeNode root, int min, int max, List<Integer> result) {
            //base case
            if (root == null) {
                return;
            }
            //subproblem if (root.key <= min) do not go left ==> if (root.key > min) go left
            if (root.key > min) {
                getRangeHelper(root.left, min, max, result);
            }
            //recursion rule
            if (root.key >= min && root.key <= max) {
                result.add(root.key);
            }
            //subproblem if (root.key >= max) do not go right ==> if (root.key < max) go right
            if (root.key < max) {
                getRangeHelper(root.right, min, max, result);
            }
        }

    }



}
