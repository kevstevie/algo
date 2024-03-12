package prob11657;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final long INF = Long.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] dis = new long[n + 1];
        Arrays.fill(dis, INF);
        dis[1] = 0;
        Route[] routes = new Route[m];
        int idx = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            routes[idx++] = new Route(s, e, c);
        }

        for (int i = 0; i < n - 1; i++) {
            for (Route route : routes) {
                if (dis[route.s] == INF) continue;
                dis[route.e] = Math.min(dis[route.e], dis[route.s] + route.c);
            }
        }
        if (bellman(routes, dis)) {
            System.out.println("-1");
            return;
        }
        StringBuilder sb = new StringBuilder();
        Arrays.stream(dis)
                .skip(2)
                .forEach(i -> sb.append(i == INF ? -1 : i).append(System.lineSeparator()));

        System.out.println(sb);
    }

    static boolean bellman(Route[] routes, long[] dis) {
        for (Route route : routes) {
            if (dis[route.e] == INF) continue;
            if (dis[route.e] > dis[route.s] + route.c) {
                return true;
            }
        }
        return false;
    }
    static class Route {
        int s;
        int e;
        int c;

        public Route(int s, int e, int c) {
            this.s = s;
            this.e = e;
            this.c = c;
        }
    }
}
