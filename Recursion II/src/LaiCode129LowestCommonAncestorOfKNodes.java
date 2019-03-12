import java.util.*;

public class LaiCode129LowestCommonAncestorOfKNodes {
    //Time:on average: O(n), worse case: O(n^2)
    //Space: O(height)  worse case: O(n)
    public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
        // Write your solution here.
        Set<TreeNode> nodeSet = new HashSet<>(nodes);
        return helper(root, nodeSet);
    }

    private TreeNode helper(TreeNode root, Set<TreeNode> nodeSet) {
        //base case
        if (root == null) {
            return null;
        }
        if (nodeSet.contains(root)) {
            return root;
        }
        //subproblem
        TreeNode leftNode = helper(root.left, nodeSet);
        TreeNode rightNode = helper(root.right, nodeSet);
        //rerursion rule
        if (leftNode != null && rightNode != null) {
            return root;
        }
        return leftNode == null ? rightNode : leftNode;
    }
}
