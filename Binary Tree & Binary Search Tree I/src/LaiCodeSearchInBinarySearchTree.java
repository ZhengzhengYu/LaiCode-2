public class LaiCodeSearchInBinarySearchTree {
    //Method 1: Recursive way
    //Time: O(height)  worse case: O(n)
    //Space: O(height) worse case: O(n)
    //public class Solution {
    //  public TreeNode search(TreeNode root, int key) {
    //    // Write your solution here
    //    //base case
    //    if (root == null || root.key == key) {
    //      return root;
    //    }
    //    //subproblem
    //    if (root.key < key) {
    //      return search(root.right, key);
    //    } else {
    //      return search(root.left, key);
    //    }
    //  }
    //}



    //Method 2: Iterative way
    //Time: O(height)  worse case: O(n)
    //Space: O(1)
    //public class Solution {
    //  public TreeNode search(TreeNode root, int key) {
    //    // Write your solution here
    //    if (root == null) {
    //      return null;
    //    }
    //    while (root != null) {
    //      if (root.key == key) {
    //        return root;
    //      } else if (root.key < key) {
    //        root = root.right;
    //      } else {
    //        root = root.left;
    //      }
    //    }
    //    return null;
    //  }
    //}


    //Method 3: Iterative way
    //Time: O(height)  worse case: O(n)
    //Space: O(1)
    public class Solution {
        public TreeNode search(TreeNode root, int key) {
            // Write your solution here
            while (root != null && root.key != key) {
                if (root.key < key) {
                    root = root.right;
                } else {
                    root = root.left;
                }
            }
            //exit while loop: root == null || root.key == key
            return root;
        }
    }

}
