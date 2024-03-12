package prob15650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        recur(0, m, new String[m], 1);
        System.out.println(sb);
    }

    static StringBuilder sb = new StringBuilder();
    static void recur(int c, int m, String[] s, int num) {
        if (c == m) {
            sb.append(String.join(" ", s)).append(System.lineSeparator());
            return;
        }
        if (num > n) return;
        s[c] = String.valueOf(num);
        recur(c + 1, m, s, num + 1);
        recur(c, m, s, num + 1);
    }
}
