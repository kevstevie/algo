package prob1197;

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

        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparing(node -> node.cost));

        List<List<Node>> l = new ArrayList<>();
        for (int i = 0; i < v + 1; i++) {
            l.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            l.get(s).add(new Node(f, c));
            l.get(f).add(new Node(s, c));
        }

        boolean[] visit = new boolean[v + 1];
        visit[0] = true;

        q.offer(new Node(1, 0));

        int ans = 0;
        int cnt = 0;

        while (!q.isEmpty()) {
            Node now = q.poll();
            int pos = now.pos;
            if (visit[pos]) continue;
            ans += now.cost;
            visit[pos] = true;
            if (++cnt == v) {
                break;
            }
            List<Node> nodes = l.get(pos);
            for (Node node : nodes) {
                if (visit[node.pos]) continue;
                q.offer(node);
            }
        }

        System.out.println(ans);

    }

    static class Node {

        int pos;
        int cost;

        public Node(int pos, int cost) {
            this.pos = pos;
            this.cost = cost;
        }
    }
}
