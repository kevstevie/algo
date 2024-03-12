package prob1562;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int d = 1_000_000_000;
    static int[][][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new int[n + 1][10][(1 << 10)];

        for (int i = 1; i < 10; i++) {
            dp[1][i][1 << i] = 1;
        }

        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < (1 << 10); k++) {
                    int visit = k | (1 << j);
                    if (j == 0) {
                        dp[i][j][visit] = (dp[i][j][visit] + dp[i - 1][j + 1][k]) % d;
                    } else if (j == 9) {
                        dp[i][j][visit] = (dp[i][j][visit] + dp[i - 1][j - 1][k]) % d;
                    } else {
                        dp[i][j][visit] = (dp[i][j][visit] + dp[i - 1][j + 1][k] + dp[i - 1][j - 1][k]) % d;
                    }

                }
            }
        }

        int ans = 0;

        for (int i = 0; i < 10; i++) {
            ans += dp[n][i][(1 << 10) - 1];
            ans %= d;
        }

        System.out.println(ans);
    }
}
