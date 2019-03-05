public class LaiCode75NumberOfDifferentBits {
    //Time: O(number of bits)
    //Space: O(1)
    public class Solution {
        public int diffBits(int a, int b) {
            // Write your solution here
            int count = 0;
            for (int c = a ^ b; c != 0; c = (c >>> 1)) {
                count += (c & 1);
            }
            return count;
        }
    }

}
