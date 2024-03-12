package uteco7.prob15989;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        long[] dp = new long[10001];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i < dp.length; i++) {
            dp[i] = 1 + i / 2 + dp[i - 3];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append(System.lineSeparator());
        }

        System.out.println(sb);
    }
}
/*
2
22
222
2222
22222

3 -> dp[7][2]
33 -> dp[
333

1 + 5 +

10
10
20
40
80
160
320
640
1280
2560
5120
 */
