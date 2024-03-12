package prob10844;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = 10_0000_0000;

        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[101][10];
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i < 101; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j + 1] % num;
                } else if (j == 9) {
                    dp[i][j] = dp[i - 1][j - 1] % num;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] % num + dp[i - 1][j + 1] % num) % num;
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < 10; i++) {
            ans += dp[n][i];
            ans %= num;
        }

        System.out.println(ans);
    }
}
