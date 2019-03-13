public class LaiCode368LowestCommonAncestorBinarySearchTreeI {
    //Time: O(height)  worse case: O(n)
    //Space: O(height) worse case: O(n)
    public TreeNode lca(TreeNode root, int p, int q) {
        // Write your solution here
        //base case
        if ((root.value - p) * (root.value - q) <= 0) {
            return root;
        }
        //recursion rule
        if (p < root.value) {
            return lca(root.left, p, q);
        }
        return lca(root.right, p, q);
    }
}
