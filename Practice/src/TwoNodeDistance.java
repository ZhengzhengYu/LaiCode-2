import java.util.*;
public class TwoNodeDistance {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        System.out.println(getDistance(root, node1, node2));
    }
    public static int getDistance(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null || node1 == null || node2 == null) {
            return 0;
        }
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        dfs(root, null, parentMap);
        Queue<TreeNode> queue = new LinkedList<>();
        HashSet<TreeNode> nodeSet = new HashSet<>();
        queue.offer(node1);
        nodeSet.add(node1);
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null && !nodeSet.contains(poll.left)) {
                    if (poll.left == node2) {
                        return result + 1;
                    }
                    queue.offer(poll.left);
                    nodeSet.add(poll.left);
                }
                if (poll.right != null && !nodeSet.contains(poll.right)) {
                    if (poll.right == node2) {
                        return result + 1;
                    }
                    queue.offer(poll.right);
                    nodeSet.add(poll.right);
                }
                TreeNode parent = parentMap.get(poll);
                if (parent != null && !nodeSet.contains(parent)) {
                    if (parent == node2) {
                        return result + 1;
                    }
                    queue.offer(parent);
                    nodeSet.add(parent);
                }
            }
            result++;
        }
        return -1;
    }

    private static void dfs(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> parentMap) {
        if (root != null) {
            parentMap.put(root, parent);
            dfs(root.left, root, parentMap);
            dfs(root.right, root, parentMap);
        }
    }

}

