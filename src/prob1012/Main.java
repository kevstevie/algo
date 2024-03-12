package prob1012;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());
        StringBuilder sb = new StringBuilder();

        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};

        for (int i = 0; i < t; i++) {
            String[] s = sc.nextLine().split(" ");
            int m = Integer.parseInt(s[0]);
            int n = Integer.parseInt(s[1]);
            int k = Integer.parseInt(s[2]);
            boolean[][] v = new boolean[m][n];
            for (int j = 0; j < k; j++) {
                String[] s1 = sc.nextLine().split(" ");
                v[Integer.parseInt(s1[0])][Integer.parseInt(s1[1])] = true;
            }
            int ans = 0;
            Deque<int[]> a = new LinkedList<>();

            for (int j = 0; j < m; j++) {
                for (int l = 0; l < n; l++) {
                    if (!v[j][l]) continue;
                    a.addLast(new int[]{j, l});
                    ans++;
                    v[j][l] = false;
                    while (!a.isEmpty()) {
                        int[] ints = a.removeLast();
                        int x = ints[0];
                        int y = ints[1];
                        for (int o = 0; o < 4; o++) {
                            if (dx[o] + x < 0 || dx[o] + x >= m || dy[o] + y < 0 || dy[o] + y >= n || !v[dx[o] +x][dy[o] + y]) {
                                continue;
                            }
                            a.addLast(new int[]{dx[o] + x, dy[o] + y});
                            v[dx[o] + x][dy[o] + y] = false;
                        }
                    }
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
