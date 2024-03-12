package uteco6.prob16562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int[] fr;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        fr = new int[n + 1];
        parent = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            fr[i + 1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            union(v, w);
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i < n + 1; i++) {
            int j = find(parent[i]);
            map.put(j, fr[j]);
        }

        int ans = 0;
        for (Integer value : map.values()) {
            ans += value;
        }

        System.out.println(ans <= k ? ans : "Oh no");
    }

    static void union(int x, int y) {
        int dx = find(x);
        int dy = find(y);

        if (fr[dx] <= fr[dy]) {
            parent[dy] = dx;
        } else {
            parent[dx] = dy;
        }
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}
/*
5 5 100
10 20 30 40 50
1 2
3 4
2 3
4 5
5 1

40 -> 10


5 4 100
1 1 1 1 1
1 5
2 4
4 3
5 4

2 -> 1
 */
