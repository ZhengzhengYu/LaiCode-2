public class LaiCode12FibonacciNumber {
    //DP
    //Time: O(n)
    //Space: O(n)
    public long fibonacci(int K) {
        if (K < 0) {
            return 0;
        }
        if (K == 0 || K == 1) {
            return K;
        }
        long[] dp = new long[K + 1];
        //base case
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= K; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[K];
    }
}
