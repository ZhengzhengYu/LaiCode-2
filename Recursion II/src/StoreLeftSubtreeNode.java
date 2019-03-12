public class StoreLeftSubtreeNode {
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
//        System.out.println("Expected: 4, 2, 1, 3, 6, 5, 7");
        getLeftTotal(root);
        System.out.println(root.leftTotal);
    }

    public static int getLeftTotal(TreeNode root) {
        //base case
        if (root == null) {
            return 0;
        }
        //subproblem
        int left = getLeftTotal(root.left);
        int right = getLeftTotal(root.right);
        //recursion rule
        root.leftTotal = left;
        return left + right + 1;
    }
}
