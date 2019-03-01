public class LaiCodeLowestCommonAncestorII {
    public class Solution {
        public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
            // Write your solution here.
            if (one == null || two == null) {
                return null;
            }
            TreeNodeP[] oneArray = {one};
            TreeNodeP[] twoArray = {two};
            int oneDepth = getDepth(oneArray);
            int twoDepth = getDepth(twoArray);
            if (oneArray[0] != twoArray[0]) {
                return null;
            }
            if (oneDepth >= twoDepth) {
                return getLCA(one, two, oneDepth - twoDepth);
            }
            return getLCA(two, one, twoDepth - oneDepth);
        }

        private int getDepth(TreeNodeP[] nodeArray) {
            int depth = 0;
            while (nodeArray[0].parent != null) {
                depth++;
                nodeArray[0] = nodeArray[0].parent;
            }
            return depth;
        }

        private TreeNodeP getLCA(TreeNodeP one, TreeNodeP two, int diffDepth) {
            while (diffDepth > 0) {
                one = one.parent;
                diffDepth--;
            }
            while (one != two) {
                one = one.parent;
                two = two.parent;
            }
            return one;
        }
    }

}
