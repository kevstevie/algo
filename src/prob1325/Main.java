package prob1325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> l = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            l.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int e = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            l.get(s).add(e);
        }

        int[] ans = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();
        boolean[] v = new boolean[n + 1];
        StringBuilder sb = new StringBuilder();
        int max = 0;

        for (int i = 1; i < n + 1; i++) {
            if (v[i]) continue;
            q.offer(i);
            v[i] = true;
            while (!q.isEmpty()) {
                Integer now = q.poll();
                List<Integer> integers = l.get(now);

                for (Integer integer : integers) {
                    if (v[integer]) continue;
                    q.offer(integer);
                    v[integer] = true;
                    ans[i]++;
                }
            }
        }
        for (int i = 0; i < n + 1; i++) {
            if (max == ans[i]) {
                sb.append(i).append(" ");
            }
        }


        System.out.println(sb);
    }
}
/*
6 5
3 1
3 2
4 3
5 3
6 3

1 2

7 4
2 1
3 2
6 5
7 6

1 5
 */