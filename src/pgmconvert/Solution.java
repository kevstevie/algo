package pgmconvert;

import java.util.Arrays;

class Solution {
    int INF = 1_000_010;

    public int solution(int x, int y, int n) {
        int[] dp = new int[y + 1];
        Arrays.fill(dp, INF);
        dp[x] = 0;

        for (int i = x + 1; i <= y; i++) {
            if (i - n < 0) {
                continue;
            }
            if (i % 2 != 0 && i % 3 != 0) {
                dp[i] = dp[i - n] + 1;
            }
            if (i % 2 == 0 && i % 3 == 0) {
                dp[i] = Math.min(dp[i - n], Math.min(dp[i / 2], dp[i / 3])) + 1;
                continue;
            }
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i - n], dp[i / 2]) + 1;
            }

            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i - n], dp[i / 3]) + 1;
            }
        }
        return dp[y] >= INF ? -1 : dp[y];
    }
}
