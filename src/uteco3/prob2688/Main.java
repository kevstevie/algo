package uteco3.prob2688;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        long[][] dp = new long[65][10];
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 10 - i;
        }
        for (int i = 2; i < 65; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    dp[i][j] += dp[i - 1][k];
                }
            }
        }

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            ans = 0;
//            for (int j = 0; j < 10; j++) {
//                ans += dp[n][j];
//            }
            if (n == 1) {
                sb.append(10).append(System.lineSeparator());
                continue;
            }
            for (int j = 0; j < 10; j++) {
                ans += dp[n - 1][j];
            }

            sb.append(ans).append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    static long ans = 0;

}
