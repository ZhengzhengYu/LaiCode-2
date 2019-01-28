public class Leetcode98ValidateBinarySearchTree_LaiCodeIsBinarySearchTreeOrNot {
    public class TreeNode {
        int key;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { key = x; }
    }
    //Method 1
    //Recursion: isBSTValid(root, min, max)从上往下传值
    //subproblem: isBSTValid(root.left, min, root.key); isBSTValid(root.right, root.key, max)
    //recursion rule: min < root.key && max > root.key && isBSTValid(root.left, min, root.key) && isBSTValid(root.right, root.key, max)
    //base case: null ==> true

    //Time Complexity: O(n)
    //Space Complexity: O(h)
    /*
    public class Solution {
      public boolean isBST(TreeNode root) {
        // Write your solution here
        return isBSTValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
      }

      private boolean isBSTValid(TreeNode root, int min, int max) {
        if (root == null) {
          return true;
        }
        return (min < root.key && max > root.key) && isBSTValid(root.left, min, root.key) && isBSTValid(root.right, root.key, max);
      }

    }
    */

    /*
    //Method 2
    //Recursion: 从下往上返回max，min
    public class Solution {
      public boolean isBST(TreeNode root) {
        int[] temp = helper(root);
        if (temp.length == 0) return true;
        if (temp[0] < temp[1]) return false;
        return true;
      }
      //  max, min
      private int[] helper(TreeNode root) {
      if (root == null) return new int[0];
      int[] left = helper(root.left);
      int[] right = helper(root.right);
      if (left.length != 0 && (left[0] < left[1] || left[0] >= root.key)) {
        return new int[] {-1, 1};
       }

      if (right.length != 0 && (right[0] < right[1] || right[1] <= root.key)) {
        return new int[] {-1, 1};
      }

      return new int[] {right.length == 0 ? root.key : right[0], left.length == 0 ? root.key : left[1]};
      }

    }
    */

    //Method 3
    //Recursion: isBST -> inOrder(root) return是否是升序排列
    //subproblem: inOrder(root.left); inOrder(root.right)
    //recursion rule: root.key > lastSeen
    //base case: null => true

    public class Solution {
        int lastSeen = Integer.MIN_VALUE;
        public boolean isBST(TreeNode root) {
            // Write your solution here
            lastSeen = Integer.MIN_VALUE;
            return inOrder(root);
        }

        private boolean inOrder(TreeNode root) {
            if (root == null) {
                return true;
            }
            if (!inOrder(root.left)) {
                return false;
            }
            if (root.key <= lastSeen) {
                return false;
            }
            lastSeen = root.key;
            return inOrder(root.right);
        }

    }

}
