public class LaiCodeDeleteInBinarySearchTree {
    public class Solution {
        public TreeNode deleteTree(TreeNode root, int key) {
            // Write your solution here
            if (root == null) {
                return null;
            }
            if (root.key > key) {
                root.left = deleteTree(root.left, key);
                return root;
            } else if (root.key < key) {
                root.right = deleteTree(root.right, key);
                return root;
            }
            if (root.left == null) { //case 1 & 2
                return root.right;
            } else if (root.right == null) { //case 3
                return root.left;
            }
            //case 4.1
            if (root.right.left == null) {
                root.right.left = root.left;
                return root.right;
            }
            //case 4.2
            TreeNode smallest = findSmallest(root.right);
            smallest.left = root.left;
            smallest.right = root.right;
            return smallest;
        }

        private TreeNode findSmallest(TreeNode root) {
            TreeNode cur = root;
            TreeNode prev = cur;
            while (cur.left != null) {
                prev = cur;
                cur = cur.left;
            }
            prev.left = cur.right;
            return cur;
        }

    }

}
