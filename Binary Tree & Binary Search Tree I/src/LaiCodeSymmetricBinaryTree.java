public class LaiCodeSymmetricBinaryTree {
    public class Solution {
        //Method 1
        //Time: O(n)
        //Space: O(height)   worse case: O(n)
//        public boolean isSymmetric(TreeNode root) {
//            if (root == null) {
//                return true;
//            }
//            return areS(root.left, root.right);
//        }


        //Method 2
        //Time: O(n)
        //Space: O(height)   worse case: O(n)
        public boolean isSymmetric(TreeNode root) {
            return areS(root, root);
        }

        private boolean areS(TreeNode root1, TreeNode root2) {
            //base case
            if (root1 == null && root2 == null) {
                return true;
            }
            if (root1 == null || root2 == null) {
                return false;
            }
            //recursion rule
            if (root1.key != root2.key) {
                return false;
            }
            //subproblem
            return areS(root1.left, root2.right) && areS(root1.right, root2.left);
        }
    }

}
