import java.util.LinkedList;
import java.util.Queue;

public class LaiCodeCheckIfBinaryTreeIsCompleted {
    //Method 1
    //Time: O(n)
    //Space: O(n)
    //public class Solution {
    //  public boolean isCompleted(TreeNode root) {
    //    // Write your solution here
    //    if (root == null) {
    //      return true;
    //    }
    //    Queue<TreeNode> queue = new LinkedList<>();
    //    queue.offer(root);
    //    boolean metNull = false;
    //    while (!queue.isEmpty()) {
    //      TreeNode cur = queue.poll();
    //      if (cur.left == null && cur.right != null) {
    //        return false;
    //      }
    //      if (metNull && (cur.left != null || cur.right != null)) {
    //        return false;
    //      }
    //      if (cur.left == null || cur.right == null) {
    //        metNull = true;
    //      }
    //      if (cur.left != null) {
    //        queue.offer(cur.left);
    //      }
    //      if (cur.right != null) {
    //        queue.offer(cur.right);
    //      }
    //    }
    //    return true;
    //  }
    //}


    //Method 2
    //Time: O(n)
    //Space: O(n)
    public class Solution {
        public boolean isCompleted(TreeNode root) {
            // Write your solution here
            if (root == null) {
                return true;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            boolean metNull = false;
            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                if (cur.left == null) {
                    metNull = true;
                } else {
                    if (metNull) {
                        return false;
                    } else {
                        queue.offer(cur.left);
                    }
                }
                if (cur.right == null) {
                    metNull = true;
                } else {
                    if (metNull) {
                        return false;
                    } else {
                        queue.offer(cur.right);
                    }
                }
            }
            return true;
        }
    }

}
