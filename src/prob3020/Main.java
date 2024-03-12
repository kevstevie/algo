package prob3020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] top = new int[h + 1];
        int[] bot = new int[h + 1];

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                bot[Integer.parseInt(br.readLine())]++;
            } else {
                top[Integer.parseInt(br.readLine())]++;
            }
        }

        for (int i = bot.length - 2; i > 0; i--) {
            bot[i] += bot[i + 1];
        }
        for (int i = bot.length - 2; i > 0; i--) {
            top[i] += top[i + 1];
        }

        int ans = Integer.MAX_VALUE;
        int cnt = 0;
        for (int i = 1; i <= h; i++) {
            int result = bot[i] + top[h - i + 1];

            if (result < ans) {
                cnt = 1;
                ans = result;
            } else if (result == ans) {
                cnt++;
            }
        }

        System.out.println(ans + " " + cnt);
    }
}
