package prob1238;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int x;
    static int[][] ar;
    static PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparing(arr -> arr[1]));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        ar = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            ar[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            int ans = a(i, x, 0);
            max = Math.max(a(x, i, ans), max);
        }

        System.out.println(max);
    }

    static int a(int s, int e, int dis) {
        if (s == e) {
            return 0;
        }
        q.clear();
        q.offer(new int[]{s, dis});
        boolean[] visit = new boolean[n + 1];

        while (!q.isEmpty()) {
            int[] now = q.poll();
            visit[now[0]] = true;
            if (now[0] == e) {
                return now[1];
            }
            for (int i = 1; i <= n; i++) {
                if (visit[i]) continue;
                if (ar[now[0]][i] == 0) continue;
                q.offer(new int[]{i, now[1] + ar[now[0]][i]});
            }
        }
        return 0;
    }

}
