package prob2098;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] w, dp;
    static int n;
    static int INF = 16_000_001;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        w = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[n][(1 << n)];

        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }

        ans = tsp(0, 1);
        System.out.println(ans);
    }

    static int tsp(int now, int visit) {

        if (visit == (1 << n) - 1) {
            if (w[now][0] == 0) {
                return INF;
            }
            return w[now][0];
        }
        if (dp[now][visit] != -1) {
            return dp[now][visit];
        }
        dp[now][visit] = INF;

        for (int i = 0; i < n; i++) {

            if ((visit & (1 << i)) == 0) {
                if (w[now][i] != 0) {
                    dp[now][visit] = Math.min(tsp(i, visit | (1 << i)) + w[now][i], dp[now][visit]);

                }
            }
            //i = 2         now = 1    visit = 0011
            // 현재 1이고 visit이 0,1 일때
            // 현재 2이고 visit이 0,1,2 일떄 + 1에서 2로가는 거리
        }
        return dp[now][visit];
    }
}
/*
4
0 7 3 3
7 0 9 2
1 9 0 12
7 7 12 0

20
 */
