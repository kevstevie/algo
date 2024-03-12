package prob1699;

import java.util.*;
import java.lang.*;
import java.io.*;


public class Main {

    static int n;

    public static void main(String[] args) throws Exception {
        var br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[] dp = new int[100001];
        int[] sqs = new int[(int) Math.sqrt(100_001)];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;


        int sq = 1;
        int gap = 3;

        for (int i = 0; i < sqs.length; i++) {
            sqs[i] = sq;
            sq += gap;
            gap += 2;
        }
//        for (int i = 0; i < 100_001; i++) {
//            int sqrt = (int) Math.sqrt(i);
//            if (i == sqrt *sqrt) {
//                dp[i] = 1;
//            }
//        }

        dp(sqs, dp);

        System.out.println(dp[n]);

    }

    static void dp(int[] sqs, int[] dp) {
        for (int i = 4; i <= n; i++) {
            int sqrt = (int) Math.sqrt(i);
            if (i == sqrt * sqrt) {
                dp[i] = 1;
                continue;
            }
            dp[i] = dp[i - 1] + 1;
            for (int j = 0; j < sqs.length; j++) {
                if (sqs[j] > i) continue;
                dp[i] = Math.min(dp[i], dp[i - sqs[j]] + dp[sqs[j]]);
            }
        }
    }
}