package utecolast.prob14620;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int val = Integer.parseInt(st.nextToken());
                arr[i][j] = val;
            }
        }
        backtrack(0, 0, 1, 1);

        System.out.println(min);
    }

    static int min = Integer.MAX_VALUE;
    static int[][] arr;
    static int n;
    static boolean[][] visit;

    static void backtrack(int cnt, int sum, int x, int y) {
        if (cnt == 3) {
            min = Math.min(sum, min);
        }
        if (x >= n - 1) {
            backtrack(cnt, sum, 1, y + 1);
            return;
        }
        if (y >= n - 1) return;
        if (visit[x][y] || visit[x + 1][y] || visit[x - 1][y] || visit[x][y + 1] || visit[x][y - 1]) {
            backtrack(cnt, sum, x+ 1,y);
            return;
        }

        int val = 0;
        val += arr[x - 1][y] + arr[x + 1][y] + arr[x][y + 1] + arr[x][y - 1] + arr[x][y];
        visit[x][y] = true;
        visit[x + 1][y] = true;
        visit[x - 1][y] = true;
        visit[x][ y + 1] = true;
        visit[x][y - 1] = true;
        backtrack(cnt + 1, sum + val, x + 1, y);
        visit[x][y] = false;
        visit[x - 1][y] = false;
        visit[x + 1][y] = false;
        visit[x][y + 1] = false;
        visit[x][y - 1] = false;
        backtrack(cnt, sum, x + 1, y);
    }
}
