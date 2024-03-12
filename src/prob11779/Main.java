package prob11779;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

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

        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparing(node -> node.dis));
        q.offer(new Node(s, 0, new ArrayList<>(), s));
        boolean[] visit = new boolean[n + 1];
        while (!q.isEmpty()) {
            Node now = q.poll();
            if (now.pos == e) {
                System.out.println(now.dis);
                System.out.println(now.stations.size());
                String collect = now.stations.stream().map(String::valueOf)
                                             .collect(Collectors.joining(" "));
                System.out.println(collect);
                return;
            }
            visit[now.pos] = true;
            List<int[]> ls = l.get(now.pos);
            for (int[] ints : ls) {
                if (visit[ints[0]]) continue;
                q.offer(new Node(ints[0], now.dis + ints[1], now.stations, ints[0]));
            }
        }
    }

    static class Node {
        int pos;
        int dis;
        List<Integer> stations;

        public Node(int pos, int dis, List<Integer> stations, int next) {
            this.pos = pos;
            this.dis = dis;
            this.stations = new ArrayList<>(stations);
            this.stations.add(next);
        }
    }

}
