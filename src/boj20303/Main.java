package boj20303;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] p;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        p = new int[n + 1][3];
        for (int i = 0; i < n + 1; i++) {
            p[n][0] = n;
            p[n][2] = 1;
        }
        int total = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int amount = Integer.parseInt(st.nextToken());
            p[i + 1][1] = amount;
            total += amount;
        }
        int[] dp = new int[total + 1];
        Arrays.fill(dp, 3001);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            union(s, e);
        }
        for (int[] ints : p) {
            int c = ints[1];
            int kk = ints[2];
            dp[c] = Math.min(kk, dp[c]);
        }
        for (int i = 0; i < total + 1; i++) {

        }

        int ans = 0;

        for (int i = 0; i < total + 1; i++) {
            if (dp[i] < k) {
                ans = Math.max(ans, dp[i]);
            }
        }

        System.out.println(ans);
    }
    static void union(int start, int end) {
        start = find(start);
        end = find(end);

        if (start > end) {
            p[start][0] = end;
        } else {
            p[end][0] = start;
        }
        p[start][1] += p[end][1];
        p[end][1] = p[start][1];
        p[start][2]++;
        p[end][2] = p[start][2];
    }
    static int find(int start) {
        if (p[start][0] == start) return start;
        return find(p[start][0]);
    }
}
