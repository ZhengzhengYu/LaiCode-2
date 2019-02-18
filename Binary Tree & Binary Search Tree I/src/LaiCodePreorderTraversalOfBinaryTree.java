import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LaiCodePreorderTraversalOfBinaryTree {
    //Method 1: Iterative way
    //Time: O(n)
    //Space: O(n)
    public class Solution {
        public List<Integer> preOrder(TreeNode root) {
            // Write your solution here
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Deque<TreeNode> stack = new LinkedList<>();
            stack.offerFirst(root);
            while (!stack.isEmpty()) {
                //the left subtree should be traverse before the right subtree
                //since stack is FILO, we should push right into the stack first,
                //so for the next step the top element of the stack is the left subtree.
                TreeNode cur = stack.pollFirst();
                result.add(cur.key);
                if (cur.right != null) {
                    stack.offerFirst(cur.right);
                }
                if (cur.left != null) {
                    stack.offerFirst(cur.left);
                }
            }
            return result;
        }
    }


    //Method 2: Recursive way
    //Time: O(n)
    //Space: O(n)
    //public class Solution {
    //  public List<Integer> preOrder(TreeNode root) {
    //    // Write your solution here
    //    List<Integer> result = new ArrayList<>();
    //    helper(root, result);
    //    return result;
    //  }
    //
    //  private void helper(TreeNode root, List<Integer> result) {
    //    //base case
    //    if (root == null) {
    //      return;
    //    }
    //    //recursion rule
    //    result.add(root.key);
    //    helper(root.left, result);
    //    helper(root.right, result);
    //  }
    //}

}
