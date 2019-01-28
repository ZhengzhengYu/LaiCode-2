public class LaiCodeTweakedIdenticalBinaryTrees {
    public class TreeNode {
        int key;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { key = x; }
    }

    //Recursion
    //subproblem: isTweakedIdentical(one.left, two.left); isTweakedIdentical(one.right, two.right); isTweakedIdentical(one.left, two.right); isTweakedIdentical(one.right, two.left)
    //recursion rule: one.key == two.key && ((isTweakedIdentical(one.left, two.left) && isTweakedIdentical(one.right, two.right)) || (isTweakedIdentical(one.left, two.right) && isTweakedIdentical(one.right, two.left)))
    //base case: one == null && two == null ==> true
    //           one == null || two == null ==> false

    //Time Complexity: O(n^2)
    //Space Complexity: O(h)

    public class Solution {
        public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
            if (one == null && two == null) {
                return true;
            }
            if (one == null || two == null) {
                return false;
            }
            return (one.key == two.key) && ((isTweakedIdentical(one.left, two.left) && isTweakedIdentical(one.right, two.right)) || (isTweakedIdentical(one.left, two.right) && isTweakedIdentical(one.right, two.left)));
        }
    }

}
