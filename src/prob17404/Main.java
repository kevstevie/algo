package prob17404;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int INF = 1001;
        int[][] m = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                m[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] dp = new int[n][3][3];

        for (int[][] ints : dp) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt, INF);
            }
        }

        dp[0][0][0] = m[0][0];
        dp[0][1][1] = m[0][1];
        dp[0][2][2] = m[0][2];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][0][j] = m[i][0] + Math.min(dp[i - 1][1][j], dp[i - 1][2][j]);
                dp[i][1][j] = m[i][1] + Math.min(dp[i - 1][0][j], dp[i - 1][2][j]);
                dp[i][2][j] = m[i][2] + Math.min(dp[i - 1][0][j], dp[i - 1][1][j]);
            }
        }
        int ans = INF * INF;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    dp[n - 1][i][j] = INF * INF;
                }
                ans = Math.min(dp[n - 1][i][j], ans);
//                System.out.println(i + " " + ans);
            }
        }

        System.out.println(ans);
    }
}
