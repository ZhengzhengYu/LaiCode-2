public class Leetcode110BalancedBinaryTree_LaiCodeisBalanced {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //Recursion
    //subproblem: isBalanced(root.left); isBalanced(root.right)
    //recursion rule: isBalanced(root.left) && isBalanced(root.right) && |getHeight(root.left) - getHeight(root.right)| <= 1
    //base case: null -> true

    //Time Complexity: O(n log n)
    //Space Complexity: O(h)
    // class Solution {
    //     public boolean isBalanced(TreeNode root) {
    //         if (root == null) {
    //             return true;
    //         }
    //         return isBalanced(root.left) && isBalanced(root.right) && Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1;
    //     }

    //     private int getHeight(TreeNode root) {
    //         if (root == null) {
    //             return 0;
    //         }
    //         return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    //     }

    // }


    //Recursion: checkBalancedAndHeight(root): if balanced return height; if unbalanced return -1
    //subproblem: checkBalancedAndHeight(root.left); checkBalancedAndHeight(root.right)
    //recursion rule:
    //         leftHeight < 0 || rightHeight < 0 ==> return -1
    //         |leftHeight - rightHeight| > 1  ==> return -1
    //         return max(leftHeight, rightHeight) + 1
    //base case: null -> 0

    //Time Complexity: O(n)
    //Space Complexity: O(h)
    class Solution {
        public boolean isBalanced(TreeNode root) {
            return checkBalancedAndHeight(root) >= 0;
        }

        //if balanced return height
        //if unbalanced return -1
        private int checkBalancedAndHeight(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftHeight = checkBalancedAndHeight(root.left);
            int rightHeight = checkBalancedAndHeight(root.right);

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
