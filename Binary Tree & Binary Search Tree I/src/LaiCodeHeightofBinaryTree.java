public class LaiCodeHeightofBinaryTree {
    //Time: O(n)
    //Space: O(height) worse case: O(n) average: O(log n)
    public class Solution {
        public int findHeight(TreeNode root) {
            // Write your solution here
            //base case
            if (root == null) {
                return 0;
            }
            //subproblem
            int leftHeight = findHeight(root.left);
            int rightHeight = findHeight(root.right);
            //recursion rule
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
