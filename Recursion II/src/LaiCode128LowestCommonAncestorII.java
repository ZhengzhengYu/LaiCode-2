//Time: O(n)
//Space: O(height) worse case: O(n)
public class LaiCode128LowestCommonAncestorII {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
        // write your solution here
        TreeNode result = helper(root, one, two);
        if (result == one) {
            if (helper(root, two, two) == null) {
                return null;
            }
        }
        if (result == two) {
            if (helper(root, one, one) == null) {
                return null;
            }
        }
        return result;
    }

    private TreeNode helper(TreeNode root, TreeNode one, TreeNode two) {
        if (root == null || root == one || root == two) {
            return root;
        }
        TreeNode leftNode = helper(root.left, one, two);
        TreeNode rightNode = helper(root.right, one, two);
        if (leftNode != null && rightNode != null) {
            return root;
        }
        return leftNode == null ? rightNode : leftNode;
    }

}
