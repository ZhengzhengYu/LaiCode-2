public class LaiCode126LowestCommonAncestorI {
    //Time: O(n)
    //Space: O(height)  worse case: O(n)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
        // Write your solution here.
        //base case
        if (root == null || root == one || root == two) {
            return root;
        }
        //subproblem
        TreeNode leftNode = lowestCommonAncestor(root.left, one, two);
        TreeNode rightNode = lowestCommonAncestor(root.right, one, two);
        //recursion rule
        if (leftNode != null && rightNode != null) {
            return root;
        }
        return leftNode == null ? rightNode : leftNode;
    }
}
