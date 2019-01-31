import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LaiCodePrintTreeinLevelOrder {
    public class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int key) {
      this.key = key;
    }
 }

    //Time: O(n)
    //Space: O(n)
    public class Solution {
        public List<Integer> bfs(TreeNode root) {
            // Write your solution here
            List<Integer> result = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                result.add(node.key);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            return result;
        }
    }

}
