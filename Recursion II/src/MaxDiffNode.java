public class MaxDiffNode {
    public TreeNode maxDiffNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode[] node = new TreeNode[1];
        int[] diff = new int[1];
        diff[0] = -1;
        helper(root, node, diff);
        return node[0];
    }

    //return the number of nodes in the subtree
    private int helper(TreeNode root, TreeNode[] node, int[] diff) {
        //base case
        if (root == null) {
           return 0;
        }
        //subproblem
        int leftNum = helper(root.left, node, diff);
        int rightNum = helper(root.right, node, diff);
        //recursion rule
        if (Math.abs(leftNum - rightNum) > diff[0]) {
            diff[0] = Math.abs(leftNum - rightNum);
            node[0] = root;
        }
        return leftNum + rightNum + 1;
    }
}
