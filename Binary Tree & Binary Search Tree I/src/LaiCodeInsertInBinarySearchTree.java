public class LaiCodeInsertInBinarySearchTree {
    //Method 1: Recursive way, return the root of the binary seach tree
    //Time: O(height)   worse case: O(n)
    //Space: O(height)  worse case: O(n)
    //public class Solution {
    //  public TreeNode insert(TreeNode root, int key) {
    //    // Write your solution here
    //    if (root == null) {
    //      return new TreeNode(key);
    //    }
    //    if (root.key < key) {
    //      root.right = insert(root.right, key);
    //    } else if (root.key > key) {
    //      root.left = insert(root.left, key);
    //    }
    //    return root;
    //  }
    //}



    //Method 2: Iterative way
    //Time: O(height)  worse case: O(n)
    //Space: O(1)
    //public class Solution {
    //  public TreeNode insert(TreeNode root, int key) {
    //    // Write your solution here
    //    if (root == null) {
    //      return new TreeNode(key);
    //    }
    //    TreeNode prev = null;
    //    TreeNode cur = root;
    //    while (cur != null && cur.key != key) {
    //      if (cur.key < key) {
    //        prev = cur;
    //        cur = cur.right;
    //      } else {
    //        prev = cur;
    //        cur = cur.left;
    //      }
    //    }
    //    //exit while loop: cur == null || cur.key == key
    //    //if cur != null then cur.key === key
    //    if (cur != null) {
    //      return root;
    //    }
    //    if (prev.key < key) {
    //      prev.right = new TreeNode(key);
    //    } else {
    //      prev.left = new TreeNode(key);
    //    }
    //    return root;
    //  }
    //}


    //Method 3: Iterative way II
    //Time: O(height)  worse case: O(n)
    //Space: O(1)
    public class Solution {
        public TreeNode insert(TreeNode root, int key) {
            // Write your solution here
            if (root == null) {
                return new TreeNode(key);
            }
            TreeNode cur = root;
            while (cur.key != key) {
                if (cur.key < key) {
                    if (cur.right == null) {
                        cur.right = new TreeNode(key);
                        break;
                    } else {
                        cur = cur.right;
                    }
                } else {
                    if (cur.left == null) {
                        cur.left = new TreeNode(key);
                        break;
                    } else {
                        cur = cur.left;
                    }
                }
            }
            return root;
        }
    }

}
