//Method: from end to start
//Time: O(n^2)
//Space:O(n)
public class LaiCode89ArrayHopperII {
    public int minJump(int[] array) {
        // Write your solution here
        //M[i] represents the minimum number of jumps from i index to the end
        int[] M = new int[array.length];
        //base case
        M[array.length - 1] = 0;
        //induction rule
        for (int i = array.length - 2; i >= 0; i--) {
            //intialize unreachable first
            int cur = -1;
            if (i + array[i] >= array.length - 1) {
                cur = 1;
            } else {
                for (int j = array[i]; j >= 1; j--) {
                    if ((cur == -1 && M[i + j] != -1) || (cur > M[i + j] + 1 && M[i + j] != -1)) {
                        cur = M[i + j] + 1;
                    }
                }
            }
            M[i] = cur;
        }
        return M[0];
    }
}
