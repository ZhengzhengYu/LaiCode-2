public class LaiCodeatothepowerofb {
    //Time: O(log b)
    //Space: O(log b)

//    public class Solution {
//      public long power(int a, int b) {
//        // Write your solution here
//        //Base case
//        if (b == 0) {
//          return 1;
//        }
//        //Recursion rule
//        long half = power(a, b / 2);
//        if (b % 2 == 0) {
//          return half * half;
//        } else {
//          return a * half * half;
//        }
//      }
//    }


    //Time: O(log b)
    //Space: O(log b)
    public class Solution {
        public long power(int a, int b) {
            // Write your solution here
            //Base case
            if (b == 0) {
                return 1;
            }
            //Recursion rule
            long half = power(a, b / 2);
            return b % 2 == 0 ? half * half : a * half * half;
        }
    }

}
