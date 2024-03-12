package uteco4.prob3067;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int ans = 0;
            int[] coins = new int[n];
            for (int j = 0; j < n; j++) {
                coins[j] = Integer.parseInt(st.nextToken());
            }
            int m = Integer.parseInt(br.readLine());
            int[] dp = new int[m + 1];
            dp[0] = 1;
            for (int j = 0; j < n; j++) {
                int coin = coins[j];
                for (int k = coin; k <= m; k++) {
                    dp[k] = dp[k] + dp[k - coin];
                }
            }
            sb.append(dp[m]).append(System.lineSeparator());
        }
        System.out.println(sb);
    }
}

/*
3
2
1 2
1000
3
1 5 10
100
2
5 7
22
 */
