package prob1967;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<List<Node>> l = new ArrayList<>();
        List<List<Node>> ll = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            l.add(new ArrayList<>());
            ll.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int root = Integer.parseInt(st.nextToken());
            int leaf = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            l.get(root).add(new Node(leaf, v));
            ll.get(root).add(new Node(leaf, v));
            ll.get(leaf).add(new Node(root, v));
        }
        // TODO: 2023/08/17 다익스트라
        int start = 0;
        int max = 0;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(1, 0));
        while(!q.isEmpty()) {
            Node now = q.poll();
            if (l.get(now.pos).isEmpty()) {
                if (max < now.cost) {
                    max = now.cost;
                    start = now.pos;
                }
                continue;
            }
            for (Node node : l.get(now.pos)) {
                q.offer(new Node(node.pos, now.cost + node.cost));
            }
        }
        PriorityQueue<Node> qq = new PriorityQueue<>(Comparator.comparing((Node node) -> node.cost).reversed());

        max = 0;
        boolean[] visit = new boolean[n + 1];

        qq.offer(new Node(start, 0));
        while (!qq.isEmpty()) {
            Node now = qq.poll();
            visit[now.pos] = true;
            max = Math.max(now.cost, max);
            for (Node node : ll.get(now.pos)) {
                if (visit[node.pos]) continue;
                qq.offer(new Node(node.pos, now.cost + node.cost));
            }
        }

        System.out.println(max);
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
