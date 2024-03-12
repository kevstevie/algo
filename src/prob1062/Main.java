package prob1062;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static boolean[] b = new boolean[26];
    static String word[];
    static int max = 0;
    static int n, k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        word = new String[n];
        for (int i = 0; i < n; i++) {
            word[i] = br.readLine();
        }

        recur(0, 0, k);

        System.out.println(max);
    }

    static void recur(int idx, int cnt, int target) {
        if (cnt == target) {
            int ans = 0;
            for (String s : word) {
                boolean flag = true;
                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    if (!b[c-'a']) {
                        flag = false;
                        break;
                    }
                }
                if (flag) ans++;
            }
            max = Math.max(ans, max);
            return;
        }
        for (int i = idx; i < 26; i++) {
            b[i] = true;
            recur(i + 1, cnt + 1, target);
            b[i] = false;
        }
    }

}
