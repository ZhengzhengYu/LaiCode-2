public class LaiCodeTweakedIdenticalBinaryTrees {
    //Recursion
    //subproblem: isTweakedIdentical(one.left, two.left); isTweakedIdentical(one.right, two.right); isTweakedIdentical(one.left, two.right); isTweakedIdentical(one.right, two.left)
    //recursion rule: one.key == two.key && ((isTweakedIdentical(one.left, two.left) && isTweakedIdentical(one.right, two.right)) || (isTweakedIdentical(one.left, two.right) && isTweakedIdentical(one.right, two.left)))
    //base case: one == null && two == null ==> true
    //           one == null || two == null ==> false
    //Time: O(n^2)
    //Space: O(height) worse case: O(n)
    public class Solution {
        public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
            if (one == null && two == null) {
                return true;
            }
            if (one == null || two == null) {
                return false;
            }
            if (one.key != two.key) {
                return false;
            }
            return((isTweakedIdentical(one.left, two.left) && isTweakedIdentical(one.right, two.right)) || (isTweakedIdentical(one.left, two.right) && isTweakedIdentical(one.right, two.left)));
        }
    }

}
