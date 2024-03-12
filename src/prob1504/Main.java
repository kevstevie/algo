package prob1504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int e;
    static int[][] k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        k = new int[n + 1][n + 1];

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            k[a][b] = c;
            k[b][a] = c;
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int ans1 = dijk(1, v1, new boolean[n + 1]);
        int ans2 = dijk(v1, v2, new boolean[n + 1]);
        int ans3 = dijk(v2, n, new boolean[n + 1]);

        int ans4 = dijk(1, v2, new boolean[n + 1]);
        int ans5 = dijk(v2, v1, new boolean[n + 1]);
        int ans6 = dijk(v1, n, new boolean[n + 1]);

        int a1 = 0;
        int a2 = 0;
        if (ans1 == -1 || ans2 == -1 || ans3 == -1) {
            a1 = -1;
        } else {
            a1 = ans1 + ans2 + ans3;
        }
        if (ans4 == -1 || ans5 == -1 || ans6 == -1) {
            a2 = -1;
        } else {
            a2 = ans4 + ans5 + ans6;
        }

        if (a1 == -1) {
            if (a2 == -1) {
                System.out.println(-1);
                return;
            }
            System.out.println(a2);
            return;
        }
        System.out.println(Math.min(a1, a2));
    }
    static class Node {
        int pos;
        int dis;

        public Node(int pos, int dis) {
            this.pos = pos;
            this.dis = dis;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "pos=" + pos +
                    ", dis=" + dis +
                    '}';
        }
    }

    static int dijk(int start, int end, boolean[] visit) {
        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparing(node -> node.dis));

        q.offer(new Node(start, 0));
        while(!q.isEmpty()) {
            Node now = q.poll();
            if (visit[now.pos]) continue;
            visit[now.pos] = true;
            if (end == now.pos) {
                return now.dis;
            }
            for (int i = 1; i <= n; i++) {
                if (k[now.pos][i] == 0) continue;
                q.offer(new Node(i, now.dis + k[now.pos][i]));
            }
        }
        return -1;
    }

}
