public class LaiCodeFibonacciNumber {
    //Time: O(n)
    //Space: O(n)
    public class Solution {
        public long fibonacci(int K) {
            // Write your solution here
            if (K < 0) {
                return 0;
            }
            if (K == 0) {
                return 0;
            }
            if (K == 1) {
                return 1;
            }
            long[] fib = new long[K + 1];
            fib[0] = 0;
            fib[1] = 1;
            for (int i = 2; i <= K; i++) {
                fib[i] = fib[i - 1] + fib[i - 2];
            }
            return fib[K];
        }
    }


    //Recursion Timeout
    //Time: O(2^n)
    //Space: O(n)
//    public class Solution {
//      public long fibonacci(int K) {
//        // Write your solution here
//        //Base case
//        if (K < 0) {
//          return 0;
//        }
//        if (K == 0) {
//          return 0;
//        }
//        if (K == 1) {
//          return 1;
//        }
//        //Recursion rule
//        return fibonacci(K - 1) + fibonacci(K - 2);
//      }
//    }

}
