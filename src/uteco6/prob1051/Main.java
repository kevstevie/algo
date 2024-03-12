package uteco6.prob1051;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n - i + 1; j++) {
                for (int k = 0; k < m - i + 1; k++) {
                    int num = arr[j][k];
                    if (num == arr[j + i - 1][k]
                            && num == arr[j + i - 1][k + i - 1]
                            && num == arr[j][k + i - 1]) {
                        max = Math.max(max, i);
                    }
                }
            }
        }

        System.out.println(max * max);
    }

}
