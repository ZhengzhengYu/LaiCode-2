import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LaiCodeGetKeysInBinaryTreeLayerByLayer {
    //Time: O(n)
    //Space: O(n)
    public class Solution {
        public List<List<Integer>> layerByLayer(TreeNode root) {
            // Write your solution here
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode temp = queue.poll();
                    list.add(temp.key);
                    if (temp.left != null) {
                        queue.offer(temp.left);
                    }
                    if (temp.right != null) {
                        queue.offer(temp.right);
                    }
                }
                result.add(list);
            }
            return result;
        }
    }
}
