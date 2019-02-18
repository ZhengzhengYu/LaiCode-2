import java.util.*;

public class LaiCodePostorderTraversalOfBinaryTree {
    //Method 1: post-order is the reverse of the pre-order with
    //          traversing right subtree before traversing left subtree.
    //Time: O(n)
    //Space: O(n)
    //public class Solution {
    //  public List<Integer> postOrder(TreeNode root) {
    //    // Write your solution here
    //    List<Integer> result = new ArrayList<>();
    //    if (root == null) {
    //      return result;
    //    }
    //    Deque<TreeNode> stack = new LinkedList<>();
    //    stack.offerFirst(root);
    //    while (!stack.isEmpty()) {
    //      TreeNode cur = stack.pollFirst();
    //      //conduct the result for the special pre-order traversal.
    //      result.add(cur.key);
    //      //in pre-order the right subtree will be traversed before
    //      //the left subtree, so pushing left child first.
    //      if (cur.left != null) {
    //        stack.offerFirst(cur.left);
    //      }
    //      if (cur.right != null) {
    //        stack.offerFirst(cur.right);
    //      }
    //    }
    //    //reverse the pre-order traversal sequence to get the post-order result.
    //    Collections.reverse(result);
    //    return result;
    //  }
    //}


    //Method 2: check relation between current node and previous node
    //          to determine which direction should go next.
    //Time: O(n)
    //Space: O(n)
    public class Solution {
        public List<Integer> postOrder(TreeNode root) {
            // Write your solution here
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Deque<TreeNode> stack = new LinkedList<>();
            stack.offerFirst(root);
            //to record the previous node on the way of DFS so that
            //we can determine the direction.
            TreeNode prev = null;
            while (!stack.isEmpty()) {
                TreeNode cur = stack.peekFirst();
                //if we are going down, either left/right direction.
                if (prev == null || cur == prev.left || cur == prev.right) {
                    //if we can still go down, try go left first.
                    if (cur.left != null) {
                        stack.offerFirst(cur.left);
                    } else if (cur.right != null) {
                        stack.offerFirst(cur.right);
                    } else {
                        //if we can not go either way, meaning cur is a leaf node.
                        stack.pollFirst();
                        result.add(cur.key);
                    }
                } else if (prev == cur.right || prev == cur.left && cur.right == null) {
                    //if we are going up from the right side or going up from left side
                    //but we can not go right afterwards.
                    stack.pollFirst();
                    result.add(cur.key);
                } else {
                    //otherwise, we are going up from left side and we can go down right side.
                    stack.offerFirst(cur.right);
                }
                prev = cur;
            }
            return result;
        }
    }


    //Method 3: Recursive way
    //Time: O(n)
    //Space: O(n)
    //public class Solution {
    //  public List<Integer> postOrder(TreeNode root) {
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
    //    helper(root.right, result);
    //    result.add(root.key);
    //  }
    //
    //}

}
