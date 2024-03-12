package boj1389;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] s = sc.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        boolean[][] v = new boolean[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            String[] s1 = sc.nextLine().split(" ");
            int i1 = Integer.parseInt(s1[0]);
            int i2 = Integer.parseInt(s1[1]);

            v[i1][i2] = true;
            v[i2][i1] = true;
        }

        Queue<Integer> q = new LinkedList<>();

        int[] ans = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            boolean[] visit = new boolean[n + 1];
            q.offer(i);
            visit[i] = true;
            int k = 0;
            int c = n - 1;
            while (c > 0) {
                int len = q.size();
                k++;
                for (int j = 0; j < len; j++) {
                    Integer next = q.poll();
                    for (int l = 1; l < n + 1; l++) {
                        if (v[next][l] && !visit[l]) {
                            q.offer(l);
                            ans[i] += k;
                            c--;
                            visit[l] = true;
                        }
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int a = 0;
        for (int i = 1; i < n + 1; i++) {
            if (min > ans[i]) {
                a = i;
                min = ans[i];
            }
        }
        System.out.println(a);
    }
}
