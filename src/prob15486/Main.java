package prob15486;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int[] t = new int[n + 2];
        int[] p = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            String[] s = sc.nextLine().split(" ");
            t[i] = Integer.parseInt(s[0]);
            p[i] = Integer.parseInt(s[1]);
        }

        int[] dp = new int[n + 2];
        int max = 0;

        for (int i = 1; i <= n + 1; i++) {

            max = Math.max(max, dp[i]);
            dp[i] = max;

            int future = i + t[i];
            if (future <= n + 1) {
                dp[future] = Math.max(dp[future], max + p[i]);
            }
        }
        System.out.println(dp[n + 1]);
    }
}
