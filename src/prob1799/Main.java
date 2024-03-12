package prob1799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] ar = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                ar[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtrack(0, 0, ar, n, new int[2 * n], new int[2 * n], 0);
        backtrack(0, 1, ar, n, new int[2 * n], new int[2 * n], 0);
        System.out.println(max + " " + max2);
        System.out.println(max + max2);
    }

    static int max = 0;
    static int max2 = 0;
    static int k = 0;

    static void backtrack(int i, int j, int[][] ar, int n, int[] v1, int[] v2, int c) {
        if (i >= n) {
            max = Math.max(c, max);
            return;
        }
        if (j >= n) {
            backtrack(i + 1, i % 2 == 1 ? 0 : 1, ar, n, v1, v2, c);
            return;
        }
        if (ar[i][j] == 0) {
            backtrack(i, j + 2, ar, n, v1, v2, c);
            return;
        }
        if (v1[i + j] != 0) {
            backtrack(i, j + 2, ar, n, v1, v2, c);
            return;
        }
        if (v2[i - j + n] != 0) {
            backtrack(i, j + 2, ar, n, v1, v2, c);
            return;
        }
        v1[i + j]++;
        v2[i - j + n]++;
        backtrack(i, j + 2, ar, n, v1, v2, c + 1);
        v1[i + j]--;
        v2[i - j + n]--;
        backtrack(i, j + 2, ar, n, v1, v2, c);
    }

    static void backtrack2(int i, int j, int[][] ar, int n, int[] v1, int[] v2, int c) {
        if (i >= n) {
            max2 = Math.max(c, max2);
            return;
        }
        if (j >= n) {
            backtrack(i + 1, i % 2 == 1 ? 1 : 0, ar, n, v1, v2, c);
            return;
        }
        if (ar[i][j] == 0) {
            backtrack(i, j + 2, ar, n, v1, v2, c);
            return;
        }
        if (v1[i + j] != 0) {
            backtrack(i, j + 2, ar, n, v1, v2, c);
            return;
        }
        if (v2[i - j + n] != 0) {
            backtrack(i, j + 2, ar, n, v1, v2, c);
            return;
        }
        v1[i + j]++;
        v2[i - j + n]++;
        backtrack(i, j + 2, ar, n, v1, v2, c + 1);
        v1[i + j]--;
        v2[i - j + n]--;
        backtrack(i, j + 2, ar, n, v1, v2, c);
    }
}
