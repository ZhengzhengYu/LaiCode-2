public class Leetcode101SymmetricTree_LaiCodeSymmetricBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //Recursion:
    //isSymmetric(root) -> areS(root.left, root.right) -> areS(root1, root2)
    //subproblem: areS(root1.left, root2.right); areS(root1.right, root2.left)
    //recursion rule:(root1.key = root2.key) + areS(root1.left, root2.right) + areS(root1.right, root2.left)
    //base case: (root1 == null && root2 == null) -> true
    //           (root1 == null || root2 == null) -> false

    //Time Complexity: O(n)
    //Space Complexity: O(h)

    class Solution {
        public boolean isSymmetric(TreeNode root) {
            // Method 1
            if (root == null) {
                return true;
            }
            return areS(root.left, root.right);
        }

        //Method 2
        // public boolean isSymmetric(TreeNode root) {
        //   return areS(root, root);
        // }

        private boolean areS(TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 == null) {
                return true;
            }
            if (root1 == null || root2 == null) {
                return false;
            }
            return (root1.val == root2.val) && areS(root1.left, root2.right) && areS(root1.right, root2.left);
        }

    }

}
