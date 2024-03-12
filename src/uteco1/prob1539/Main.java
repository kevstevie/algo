package uteco1.prob1539;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<int[]>> arr = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }

        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr.get(s).add(new int[]{e, c});
            arr.get(e).add(new int[]{s, c});
            max = Math.max(c, max);
            min = Math.min(c, min);
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int ans = 0;
        int mid = 0;
        loop:
        while (min <= max) {
            mid = (min + max) / 2;
            Queue<int[]> q = new LinkedList<>();
            boolean[] v = new boolean[n + 1];
            q.offer(new int[]{start, 0});
            v[start] = true;
            while (!q.isEmpty()) {
                int[] poll = q.poll();
                int pos = poll[0];
                if (pos == end) {
                    min = mid + 1;
                    ans = mid;
                    continue loop;
                }
                List<int[]> ints = arr.get(pos);
                for (int[] i : ints) {
                    if (v[i[0]]) continue;
                    if (i[1] < mid) continue;
                    q.offer(new int[]{i[0], i[1]});
                    v[i[0]] = true;
                }
            }
            max = mid - 1;
        }

        System.out.println(ans);

    }
}
/*
4 4
1 4 100
1 3 120
1 2 2
3 4 120
1 4

2 2
1 2 50
1 2 100
1 2
 */
