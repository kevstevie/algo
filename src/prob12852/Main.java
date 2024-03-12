package prob12852;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] dp = new int[100_000_1];
        int[] pre = new int[100_000_1];

        dp[0] = 0;
        pre[0] = 0;

        dp[1] = 0;
        pre[1] = 1;

        dp[2] = 1;
        pre[2] = 1;

        dp[3] = 1;
        pre[3] = 1;

        for (int i = 4; i < dp.length; i++) {
            if (i % 6 == 0) {
                int min = Math.min(dp[i / 3], Math.min(dp[i / 2], dp[i - 1]));
                if (min == dp[i / 3]) {
                    dp[i] = dp[i / 3] + 1;
                    pre[i] = i / 3;
                } else if (min == dp[i / 2]) {
                    dp[i] = dp[i / 2] + 1;
                    pre[i] = i / 2;
                } else {
                    dp[i] = dp[i - 1] + 1;
                    pre[i] = i - 1;
                }
            } else if (i % 3 == 0) {
                if (dp[i / 3] > dp[i - 1]) {
                    dp[i] = dp[i - 1] + 1;
                    pre[i] = i - 1;
                } else {
                    dp[i] = dp[i / 3] + 1;
                    pre[i] = i / 3;
                }
            } else if (i % 2 == 0) {
                if (dp[i / 2] > dp[i - 1]) {
                    dp[i] = dp[i - 1] + 1;
                    pre[i] = i - 1;
                } else {
                    dp[i] = dp[i / 2] + 1;
                    pre[i] = i / 2;
                }
            } else {
                dp[i] = dp[i - 1] + 1;
                pre[i] = i - 1;
            }
        }

        System.out.println(dp[n]);
        StringBuilder sb = new StringBuilder();
        sb.append(n);
        int k = n;
        while (k != 1) {
            sb.append(" ").append(pre[k]);
            k = pre[k];
        }
        System.out.println(sb);
    }
}
