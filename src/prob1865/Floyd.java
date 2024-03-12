package prob1865;

import java.util.Arrays;
import java.util.Scanner;

public class Floyd {

    static int INF = Integer.MAX_VALUE / 10;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = Integer.parseInt(sc.nextLine());

        StringBuilder sb = new StringBuilder();
        for (int cases = 0; cases < tc; cases++) {
            String[] split = sc.nextLine().split(" ");
            int n = Integer.parseInt(split[0]);
            int m = Integer.parseInt(split[1]);
            int w = Integer.parseInt(split[2]);

            int[][] arr = new int[n + 1][n + 1];
            for (int i = 0; i < n + 1; i++) {
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
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    for (int k = 1; k < n + 1; k++) {
                        arr[j][k] = Math.min(arr[j][k], arr[j][i] + arr[i][k]);
                    }
                }
            }
            boolean ans = false;
            for (int i = 1; i < n + 1; i++) {
                ans = kk(arr, i, n);
                if (ans) {
                    break;
                }
            }

            sb.append(ans ? "YES" : "NO").append(System.lineSeparator());
        }

        System.out.println(sb);

    }
    static boolean kk(int[][] arr, int s, int n) {
        for (int i = s + 1; i < n + 1; i++) {
            if (arr[s][i] + arr[i][s] < 0) {
                return true;
            }
        }
        return false;
    }
}
