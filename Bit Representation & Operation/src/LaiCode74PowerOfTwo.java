public class LaiCode74PowerOfTwo {
    //Method 1
    //Time: O(n)
    //Space: O(1)
//    public class Solution {
//      public boolean isPowerOfTwo(int number) {
//        // Write your solution here
//        if (number <= 0) {
//          return false;
//        }
//        int numsOne = 0;
//        for (int i = 0; i < 31; i++) {
//          if (((number >> i) & 1) == 1) {
//            numsOne++;
//          }
//        }
//        return numsOne == 1;
//      }
//    }


    //Method 2
    //Time: O(1)
    //Space: O(1)
    public class Solution {
        public boolean isPowerOfTwo(int number) {
            // Write your solution here
            return ((number & (number - 1)) == 0 && number > 0);
        }
    }

}
