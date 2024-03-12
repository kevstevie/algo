package uteco5.prob11059;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int len = s.length();

        int[] dp = new int[1001];

        for (int i = 0; i < len; i++) {
            dp[i + 1] = dp[i] + s.charAt(i) - '0';
        }

        int ans = 0;
        for (int i = 1; i < len; i++) {
            for (int j = i + 1; j <= len; j += 2) {
                int mid = (i + j) / 2;
                if (dp[mid] - dp[i -1] == dp[j] - dp[mid]) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        System.out.println(ans);
    }
}
/*
67896788887

6

76789798

6

4527

4

18762488

12378911

0 -> 2
 */
