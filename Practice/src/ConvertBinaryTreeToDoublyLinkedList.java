public class ConvertBinaryTreeToDoublyLinkedList {
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
        convertBTtoDLL(root);
        printNode(head);
    }

    static TreeNode head = null;
    static TreeNode prev = null;
    public static void convertBTtoDLL(TreeNode root) {
        //base case
        if (root == null) {
            return;
        }
        //subproblem
        convertBTtoDLL(root.left);
        //recursion rule
        if (prev == null) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        //subproblem
        convertBTtoDLL(root.right);
    }

    public static void printNode(TreeNode root) {
        while (root != null) {
            System.out.print(root.key + " , ");
            root = root.right;
        }
    }
}
