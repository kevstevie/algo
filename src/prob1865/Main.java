package prob1865;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final int INF = 50000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = Integer.parseInt(sc.nextLine());

        StringBuilder sb = new StringBuilder();
        for (int cases = 0; cases < tc; cases++) {
            String[] split = sc.nextLine().split(" ");
            int n = Integer.parseInt(split[0]);
            int m = Integer.parseInt(split[1]);
            int w = Integer.parseInt(split[2]);

            int[] dis = new int[n + 1];
            Arrays.fill(dis, INF);
            dis[0] = 0;

            int[][] arr = new int[n + 1][n + 1];
            for (int i = 1; i < n + 1; i++) {
                Arrays.fill(arr[i], INF);
                arr[i][i] = 0;
            }

            for (int i = 0; i < m; i++) {
                String[] input = sc.nextLine().split(" ");
                int s = Integer.parseInt(input[0]);
                int e = Integer.parseInt(input[1]);
                int t = Integer.parseInt(input[2]);

                arr[s][e] = Math.min(arr[s][e], t);
                arr[e][s] = Math.min(arr[e][s], t);

            }
            for (int i = 0; i < w; i++) {
                String[] input = sc.nextLine().split(" ");
                int s = Integer.parseInt(input[0]);
                int e = Integer.parseInt(input[1]);
                int t = Integer.parseInt(input[2]);

                arr[s][e] = Math.min(arr[s][e], -t);
            }
            boolean ans = bellman(n, arr, dis);
            sb.append(ans ? "YES" : "NO").append(System.lineSeparator());
        }

        System.out.println(sb);
    }
    // TODO: 2023/08/16 N+1번째 노드를 시작으로 벨만포드

    private static boolean bellman(int n, int[][] arr, int[] dis) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n + 1; j++) {
                for (int k = 0; k < n + 1; k++) {
                    if (dis[j] == INF) continue;
                    dis[k] = Math.min(dis[k], dis[j] + arr[j][k]);
                }
            }
        }
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (dis[i] == INF) continue;
                if (dis[j] > dis[i] + arr[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
