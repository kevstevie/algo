package prob13549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] visit = new boolean[3000100];

        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparing(it -> it.dis));

        q.offer(new Node(n, 0));
        while (!q.isEmpty()) {
            Node now = q.poll();
            int pos = now.pos;
            int cnt = now.dis;
            visit[pos] = true;

            if (pos == k) {
                System.out.println(cnt);
                return;
            }
            if (pos * 2 <= k + 2 && !visit[pos * 2]) {
                q.offer(new Node(pos * 2, cnt));
            }
            if (pos + 1 <= k + 2  && !visit[pos + 1]) {
                q.offer(new Node(pos + 1, cnt + 1));
            }
            if (pos != 0 && !visit[pos - 1]) {
                q.offer(new Node(pos - 1, cnt + 1));
            }

        }
    }

    static class Node {
        int pos;
        int dis;

        public Node(int pos, int dis) {
            this.pos = pos;
            this.dis = dis;
        }
    }
}
