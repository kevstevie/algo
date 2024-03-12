package pgmjump;

class Solution {
    int d = 1_234_567;
    public long solution(int n) {
        long[] dp = new long[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] % d + dp[i - 2] % d) % d;
        }
        return dp[n];
    }
}

