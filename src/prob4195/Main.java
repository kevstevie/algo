package prob4195;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static Map<String, Integer> map;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            map = new HashMap<>();
            int idx = 0;
            parent = new int[100001];
            for (int j = 0; j < parent.length; j++) {
                parent[i] = i;
            }
            int n = Integer.parseInt(br.readLine());
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                String s2 = st.nextToken();
                if (!map.containsKey(s)) {
                    map.put(s, idx++);
                }
                if (!map.containsKey(s2)) {
                    map.put(s2, idx++);
                }
                union(map.get(s), map.get(s2));
                int cnt = 0;
                int pa = find(map.get(s));
                for (int value : map.values()) {
                    int i1 = find(value);
                    if (i1 == pa) {
                        cnt++;
                    }
                }
                sb.append(cnt).append(System.lineSeparator());
            }

        }
        System.out.println(sb);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a > b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }

    static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }
}
