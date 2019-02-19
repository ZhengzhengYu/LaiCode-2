public class LaiCodeIsBinarySearchTreeOrNot {
    //Method 1: isBSTValid(root, min, max)从上往下传值
    //Time: O(n)
    //Space: O(height)  worse case: O(n)
    public class Solution {
        public boolean isBST(TreeNode root) {
            // Write your solution here
            return isBSThelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        private boolean isBSThelper(TreeNode root, int min, int max) {
            if (root == null) {
                return true;
            }
            if (root.key <= min || root.key >= max) {
                return false;
            }
            return isBSThelper(root.left, min, root.key) && isBSThelper(root.right, root.key, max);
        }
    }


    //Method 2 Recursion: 从下往上返回max，min
    //Time: O(n)
    //Space: O(height) worse case: O(n)
    //public class Solution {
    //  public boolean isBST(TreeNode root) {
    //    // Write your solution here
    //    int[] result = helper(root);
    //    if (result.length == 0) {
    //      return true;
    //    }
    //    if (result[0] < result[1]) {
    //      return false;
    //    }
    //    return true;
    //  }
    //
    //  private int[] helper(TreeNode root) {
    //    //base case
    //    if (root == null) {
    //      return new int[0];
    //    }
    //    //subproblem
    //    int[] left = helper(root.left);
    //    int[] right = helper(root.right);
    //    //recursion rule
    //    if (left.length != 0 && (left[0] < left[1] || left[0] >= root.key)) {
    //      return new int[] {-1, 1};
    //    }
    //    if (right.length != 0 && (right[0] < right[1] || right[1] <= root.key)) {
    //      return new int[] {-1, 1};
    //    }
    //    return new int[] {right.length == 0 ? root.key : right[0], left.length == 0 ? root.key : left[1]};
    //  }
    //}


    //Method 3 Recursion: isBST -> inOrder(root) return是否是升序排列
    //Time: O(n)
    //Space: O(height)  worse case: O(n)
    //public class Solution {
    //  int lastSeen;
    //  public boolean isBST(TreeNode root) {
    //    // Write your solution here
    //    lastSeen = Integer.MIN_VALUE;
    //    return inOrder(root);
    //  }
    //
    //  //中序遍历&&判断是否是升序排列
    //  private boolean inOrder(TreeNode root) {
    //    //base case
    //    if (root == null) {
    //      return true;
    //    }
    //    //subproblem
    //    //recursion rule
    //    if (!inOrder(root.left)) {
    //      return false;
    //    }
    //    if (root.key <= lastSeen) {
    //      return false;
    //    }
    //    lastSeen = root.key;
    //    return inOrder(root.right);
    //  }
    //}


}
