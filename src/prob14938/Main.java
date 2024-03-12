package prob14938;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int r;
    static long[][] map;
    static int[] ar;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        ar = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int j = Integer.parseInt(st.nextToken());
            ar[i] = j;
        }
        map = new long[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(map[i], Integer.MAX_VALUE);
            map[i][i] = 0;
        }
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            map[start][end] = dist;
            map[end][start] = dist;
        }
        int max = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (map[j][k] == 0) continue;
                    map[j][k] = Math.min(map[j][k], map[j][i] + map[i][k]);
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            int ans = 0;
            for (int j = 1; j <= n; j++) {
                if (map[i][j] <= m) {
                    ans += ar[j];
                }
            }
            max = Math.max(ans, max);
        }

        System.out.println(max);
    }
}
