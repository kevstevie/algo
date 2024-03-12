package prob2623;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] g = new int[n + 1][n + 1];
        int[] cnt = new int[n + 1];
        int flag = 0;

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int j = Integer.parseInt(st.nextToken());
            int prev = Integer.parseInt(st.nextToken());
            for (int k = 0; k < j - 1; k++) {
                int next = Integer.parseInt(st.nextToken());
                g[prev][next] = 1;
                prev = next;
            }
        }

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (g[i][j] == 1) {
                    cnt[j]++;
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[n + 1];

        for (int i = 1; i < n + 1; i++) {
            if (cnt[i] == 0) {
                q.offer(i);
                visit[i] = true;
            }
        }

        while (!q.isEmpty()) {
            Integer now = q.poll();
            ans.append(now).append(System.lineSeparator());
            flag++;
            for (int i = 1; i < n + 1; i++) {
                if (g[now][i] == 1) {
                    g[now][i] = 0;
                    cnt[i]--;
                }
                if (visit[i]) continue;
                if (cnt[i] == 0) {
                    q.offer(i);
                    visit[i] = true;
                }
            }
        }
        if (flag != n) {
            System.out.println(0);
            return;
        }

        System.out.println(ans);
    }
}
/*
3 2
3 1 2 3
2 3 2

4 3
3 1 2 3
2 4 3
2 2 3
 */
