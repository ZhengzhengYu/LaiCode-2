import javax.swing.tree.TreeNode;

public class Leetcode104MaximumDepthofBinaryTree_LaiCodeGetHeight {
    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
     }

//Recursion
//subproblem:maxDepth(root.left); maxDepth(root.right)
//recursion rule:max(maxDepth(root.left), maxDepth(root.right)) + 1
//base case:null -> 0

//Time Complexity
//Each time call: O(1)
//Total O(n) function calls
//Summary:O(n)

//Space Complexity
//O(height)
//Worst case:O(n)
//On everage:O(log n)

    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }

}
