package uteco4.prob5214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Integer>> tubes = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            tubes.add(new ArrayList<>());
        }

        List<List<Integer>> stations = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            stations.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                int c = Integer.parseInt(st.nextToken());
                tubes.get(i).add(c);
                stations.get(c).add(i);
            }
        }

        Queue<Node> q = new LinkedList<>();
        boolean[] visit = new boolean[m];
        q.offer(new Node(1, 1));
        while (!q.isEmpty()) {
            Node now = q.poll();
            int pos = now.pos;
            if (pos == n) {
                ans = Math.min(ans, now.dis);
            }
            List<Integer> station = stations.get(pos);
            for (Integer i : station) {
                if(visit[i]) continue;
                visit[i] = true;
                List<Integer> tube = tubes.get(i);
                for (Integer integer : tube) {
                    q.offer(new Node(integer, now.dis + 1));
                }
            }
        }

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);

    }

    static int ans = Integer.MAX_VALUE;

    static class Node {

        int pos;
        int dis;

        public Node(int pos, int dis) {
            this.pos = pos;
            this.dis = dis;
        }
    }

}
/*
3 2 2
1 2
2 3

3

5 2 4
1 2
2 3
3 2
4 5

-1

4 2 2
1 2
2 1
1 2
3 4

-1


 */
