package uteco2.prob17141;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int ans = Integer.MAX_VALUE;
    static List<int[]> l;
    static int[][] arr;
    static boolean[][] v;
    static int n;
    static int m;
    static int cnt;
    static int twos = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = new ArrayList<>();

        cnt = n * n;

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
                if (num == 2) {
                    l.add(new int[]{i, j});
                    twos++;
                }
                if (num == 1) {
                    cnt--;
                }
            }
        }
        int[] c = new int[m];
        v = new boolean[n][n];

        recur(0, 0, c);

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans - 1);
    }

    static int f = 0;
    static int ss = 0;

    static void recur(int idx, int cnt, int[] c) {
        if (idx > twos) {
            return;
        }
        if (cnt == m) {
            bfs(c);
            return;
        }
        recur(idx + 1, cnt, c);
        c[cnt] = idx;
        recur(idx + 1, cnt + 1, c);
    }

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int exp = 0;

    static void bfs(int[] c) {
        Queue<int[]> q = new LinkedList<>();
        v = new boolean[n][n];
        int temp = cnt;
        for (int i : c) {
            q.offer(l.get(i));
            v[l.get(i)[0]][l.get(i)[1]] = true;
            temp--;
        }
        exp = 0;
        times(q, temp);
    }

    private static void times(Queue<int[]> q, int temp) {
        int size = q.size();
        for (int i = 0; i < size; i++) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];

            for (int j = 0; j < 4; j++) {
                int xx = x + dx[j];
                int yy = y + dy[j];

                if (xx >= n || yy >= n || xx < 0 || yy < 0 || v[xx][yy] || arr[xx][yy] == 1) {
                    continue;
                }
                q.offer(new int[]{xx, yy});
                v[xx][yy] = true;
                temp--;
            }
        }
        exp++;
        if (q.isEmpty()) {
            if (temp == 0) {
                ans = Math.min(ans, exp);
                return;
            } else {
                return;
            }
        }
        times(q, temp);
    }
}

/*
2 1
2 2
2 2
 */
