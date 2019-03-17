//Time: O(n^2)
//Space: O(n)
public class LaiCode87MaxProductOfCuttingRope {
    public int maxProduct(int length) {
        // Write your solution here
        //M[i] represents the max product with i meters at least one cut
        int[] M = new int[length + 1];
        //base case
        M[0] = 0;
        M[1] = 0;
        //induction rule
        for (int i = 2; i <= length; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                curMax = Math.max(curMax, j * Math.max(i - j, M[i - j]));
            }
            M[i] = curMax;
        }
        return M[length];
    }
}
