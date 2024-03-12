package prob1240;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static List<List<Node>> l = new ArrayList<>();
    static int n, m;
    static int INF = 20000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n + 1; i++) {
            l.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            l.get(s).add(new Node(f, d));
            l.get(f).add(new Node(s, d));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());

            sb.append(bfs(s, f)).append(System.lineSeparator());
        }

        System.out.println(sb);
    }

    static int bfs(int s, int f) {
        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparing(node -> node.distance));
        boolean[] visit = new boolean[n + 1];

        q.offer(new Node(s, 0));
        visit[s] = true;
        while (!q.isEmpty()) {
            Node now = q.poll();
            visit[now.position] = true;
            if (now.position == f) {
                return now.distance;
            }
            for (Node node : l.get(now.position)) {
                if (visit[node.position]) {
                    continue;
                }
                q.offer(new Node(node.position, now.distance + node.distance));
            }
        }
        return 0;
    }

    static class Node {
        int position;
        int distance;

        public Node(int position, int distance) {
            this.position = position;
            this.distance = distance;
        }
    }
}
