import java.util.ArrayList;
import java.util.List;

public class LaiCodeGetKeysInBinarySearchTreeInGivenRange {
    public class TreeNode {
        int key;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { key = x; }
    }

    //Recursion: getRangeVoid(root, min, max)
    //subproblem: getRangeVoid(root.left, min, max); getRangeVoid(root.right, min, max)
    //recursion rule: getRangeVoid(root.left, min, max) + (root.key >= min && root.key <= max) add to list + getRangeVoid(root.right, min, max)
    //base case: null => return
    //Time Complexity: O(n)
    //Space Complexity: O(h)

    public class Solution {
        public List<Integer> getRange(TreeNode root, int min, int max) {
            // Write your solution here
            List<Integer> result = new ArrayList<>();
            getRangeVoid(root, min, max, result);
            return result;
        }

      /*
      private void getRangeVoid (TreeNode root, int min, int max, List<Integer> result) {
        if (root == null) {
          return;
        }

        getRangeVoid(root.left, min, max, result);
        if (root.key >= min && root.key <= max) {
          result.add(root.key);
        }
        getRangeVoid(root.right, min, max, result);
      }
      */

        //brach pruning
        //if (root.key <= min) do not go left ==> if (root.key > min) go left
        //if (root.key >= max) do not go right ==> if (root.key < max) go right
        private void getRangeVoid (TreeNode root, int min, int max, List<Integer> result) {
            if (root == null) {
                return;
            }
            if (root.key > min) {
                getRangeVoid(root.left, min, max, result);
            }
            if (root.key >= min && root.key <= max) {
                result.add(root.key);
            }
            if (root.key < max) {
                getRangeVoid(root.right, min, max, result);
            }
        }

    }

}
