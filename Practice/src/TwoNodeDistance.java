import java.util.*;
public class TwoNodeDistance {
    public int getDistance(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null || node1 == null || node2 == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        HashSet<TreeNode> nodeSet = new HashSet<>();
        queue.offer(node1);
        nodeSet.add(node1);
        int result = 0;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.left != null) {
                if (poll.left == node2) {
                    return result + 1;
                }
                if (!nodeSet.contains(poll.left)) {
                    queue.offer(poll.left);
                    nodeSet.add(poll.left);
                }
            }
        }

    }
}

