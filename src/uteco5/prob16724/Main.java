package uteco5.prob16724;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] arr = new char[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        parent = new int[n * m];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = arr[i][j];
                int d = i * m + j;
                switch (c) {
                    case 'D':
                        union(d, (i + 1) * m + j);
                        break;
                    case 'L':
                        union(d, (i) * m + j - 1);
                        break;
                    case 'R':
                        union(d, (i) * m + j + 1);
                        break;
                    case 'U':
                        union(d, (i - 1) * m + j);
                        break;
                }
            }
        }
        Set<Integer> s = new HashSet<>();
        for (int i : parent) {
            s.add(find(i));
        }

        System.out.println(s.size());
    }

    static int[] parent;

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        parent[a] = b;
    }
    static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

}
