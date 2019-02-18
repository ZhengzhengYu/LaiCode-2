public class LaiCodeCheckIfBinaryTreeIsBalanced {
    //Method 1:Not an optimal sulution
    //Time: O(n log n)
    //Space: O(height) worse case: O(n)
    //public class Solution {
    //  public boolean isBalanced(TreeNode root) {
    //    // Write your solution here
    //    //base case
    //    if (root == null) {
    //      return true;
    //    }
    //    //recursion rule
    //    int leftHeight = getHeight(root.left);
    //    int rightHeight = getHeight(root.right);
    //    if (Math.abs(leftHeight - rightHeight) > 1) {
    //      return false;
    //    }
    //    //subproblem
    //    return isBalanced(root.left) && isBalanced(root.right);
    //  }
    //
    //  private int getHeight(TreeNode root) {
    //    if (root == null) {
    //      return 0;
    //    }
    //    int leftHeight = getHeight(root.left);
    //    int rightHeight = getHeight(root.right);
    //    return Math.max(leftHeight, rightHeight) + 1;
    //  }
    //
    //}


    //Method 2
    //Time: O(n)
    //Space: O(height)
    public class Solution {
        public boolean isBalanced(TreeNode root) {
            // Write your solution here
            return isBalancedAndHeight(root) >= 0;
        }

        //if balanced return height, else return -1
        private int isBalancedAndHeight(TreeNode root) {
            //base case
            if (root == null) {
                return 0;
            }
            //subproblem
            int leftHeight = isBalancedAndHeight(root.left);
            int rightHeight = isBalancedAndHeight(root.right);
            //recursion rule
            if (leftHeight < 0 || rightHeight < 0) {
                return -1;
            }
            if (Math.abs(leftHeight - rightHeight) > 1) {
                return -1;
            }
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

}
