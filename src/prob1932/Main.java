package prob1932;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] ar = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                ar[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = ar[1][1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                ar[i][j] = Math.max(ar[i - 1][j - 1], ar[i - 1][j]) + ar[i][j];
                max = Math.max(ar[i][j], max);
            }
        }

        System.out.println(max);
    }

}
