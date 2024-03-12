package uteco3.prob28298;

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
        int k = Integer.parseInt(st.nextToken());

        char[][] arr = new char[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = s.charAt(j);
                arr[i][j] = c;
            }
        }

        char[][] ans = new char[k][k];
        int num = 0;

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                int[] cnt = new int[26];
                for (int l = i; l < n; l += k) {
                    for (int h = j; h < m; h += k) {
                        cnt[arr[l][h] - 'A']++;
                    }
                }
                int max = 0;
                for (int l = 0; l < 26; l++) {
                    if (max < cnt[l]) {
                        max = cnt[l];
                        ans[i][j] = ((char) (l + 'A'));
                    }
                }
                num += (n / k) * (m / k) - max;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = ans[i % k][j % k];
            }
        }

        StringBuilder sb = new StringBuilder();
        System.out.println(num);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(arr[i][j]);
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb);
    }
}
/*
4 4 2
AAAA
BBBB
EEFF
GAGB

7

4 4 2
ACDB
EHFU
ACBB
EKFU

4 4 2
ANDJ
AJEE
ANDJ
AJEE

4 6 2
CBABAB
ACBBCA
BPAZBB
BBAABB
 */


