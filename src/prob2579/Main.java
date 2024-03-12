package prob2579;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(sc.nextLine());
        }

        int[][] dp = new int[n][3];
        if (n == 1) {
            System.out.println(a[0]);
            return;
        }
        dp[0][1] = a[0];
        dp[1][1] = a[1];
        dp[1][2] = a[0] + a[1];

        for (int i = 2; i < n; i++) {
            dp[i][1] = Math.max(dp[i - 2][2], dp[i - 2][1]) + a[i];
            dp[i][2] = dp[i - 1][1] + a[i];
        }
        int ans = Math.max(dp[n - 1][1], dp[n - 1][2]);

        System.out.println(ans);
    }
}
