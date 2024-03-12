package prob10942;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");

        int m = Integer.parseInt(br.readLine());

        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            if (s[i - 1].equals(s[i])) {
                dp[i - 1][i] = 1;
            }
        }

        for(int i = 2; i < n; i++){
            for(int j = 0; j < n - i; j++){
                if(s[j].equals(s[j + i]) && dp[j + 1][j + i - 1] == 1)
                    dp[j][j + i] = 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String[] s1 = br.readLine().split(" ");
            sb.append(dp[Integer.parseInt(s1[0]) - 1][Integer.parseInt(s1[1]) - 1]).append(System.lineSeparator());
        }

        System.out.println(sb);
    }
}
