import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LaiCodeInorderTraversalOfBinaryTree {
    //Method 1: Iterative way
    //Time: O(n)
    //Space: O(n)
    public class Solution {
        public List<Integer> inOrder(TreeNode root) {
            // Write your solution here
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Deque<TreeNode> stack = new LinkedList<>();
            TreeNode cur = root;
            while (cur != null || !stack.isEmpty()) {
                //always try go to the left side to see if there is any node
                //should be traverse before the cur node, cur node is stored
                //on stack since it has not been traverse yet.
                if (cur != null) {
                    stack.offerFirst(cur);
                    cur = cur.left;
                } else {
                    //if can not go left, meaning all the nodes on the left side
                    //of the top node on stack has been traversed, the next
                    //traversing node should be the top node on stack.
                    cur = stack.pollFirst();
                    result.add(cur.key);
                    //the next subtree we want to traverse is cur.right.
                    cur = cur.right;
                }
            }
            return result;
        }
    }

    //Method 2: Recursive way
    //Time: O(n)
    //Space: O(n)
    //public class Solution {
    //  public List<Integer> inOrder(TreeNode root) {
    //    // Write your solution here
    //    List<Integer> result = new ArrayList<>();
    //    helper(root, result);
    //    return result;
    //  }
    //
    //  private void helper(TreeNode root, List<Integer> result) {
    //    if (root == null) {
    //      return;
    //    }
    //    helper(root.left, result);
    //    result.add(root.key);
    //    helper(root.right, result);
    //  }
    //}

}
