package prob1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<List<int[]>> l = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            l.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            var st = new StringTokenizer(br.readLine());
            l.get(Integer.parseInt(st.nextToken())).add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        var st = new StringTokenizer(br.readLine());
        var s = Integer.parseInt(st.nextToken());
        var e = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparing(arr -> arr[1]));
        q.offer(new int[]{s, 0});
        boolean[] visit = new boolean[n + 1];
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (now[0] == e) {
                System.out.println(now[1]);
                return;
            }
            visit[now[0]] = true;
            List<int[]> ls = l.get(now[0]);
            for (int[] ints : ls) {
                if (visit[ints[0]]) continue;
                q.offer(new int[]{ints[0], now[1] + ints[1]});
            }
        }
    }

}
