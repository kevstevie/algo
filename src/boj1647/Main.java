package boj1647;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int max = 0;
        int cnt = 0;
        int ans = 0;

        Queue<Node> q = new PriorityQueue<>(Comparator.comparing(node -> node.cost));

        arr = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            q.offer(new Node(s, e, c));
        }

        while (!q.isEmpty()) {
            Node now = q.poll();
            if (find(now.start) == find(now.end)) {
                continue;
            }
            union(now.start, now.end);
            max = Math.max(now.cost, max);
            ans += now.cost;
            if (++cnt == n - 1) break;
        }
        System.out.println(ans - max);
    }

    static class Node {
        int start;
        int end;
        int cost;

        public Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    static void union(int start, int end) {
        start = find(start);
        end = find(end);

        if (start > end) {
            arr[start] = end;
        } else {
            arr[end] = start;
        }
    }

    static int find(int start) {
        if (arr[start] == start) return start;
        return find(arr[start]);
    }
}
