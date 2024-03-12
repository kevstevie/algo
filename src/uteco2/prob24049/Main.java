package uteco2.prob24049;

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

        boolean[][] arr = new boolean[n + 1][m + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i][0] = st.nextToken().equals("1");
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            arr[0][i] = st.nextToken().equals("1");
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                arr[i][j] = arr[i - 1][j] ^ arr[i][j - 1];
            }
        }

        System.out.println(arr[n][m] ? 1 : 0);
    }

}
