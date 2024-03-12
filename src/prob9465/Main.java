package prob9465;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] ar = new int[n + 1][2];
            int[][] dp = new int[n + 1][2];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                ar[j][0] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                ar[j][1] = Integer.parseInt(st.nextToken());
            }
            dp[1][0] = ar[1][0];
            dp[1][1] = ar[1][1];
            for (int j = 2; j <= n; j++) {
                dp[j][0] = Math.max(dp[j - 1][1], Math.max(dp[j - 2][0], dp[j - 2][1])) + ar[j][0];
                dp[j][1] = Math.max(dp[j - 1][0], Math.max(dp[j - 2][0], dp[j - 2][1])) + ar[j][1];
            }
            sb.append(Math.max(dp[n][0], dp[n][1])).append(System.lineSeparator());
        }

        System.out.println(sb);
    }

}
