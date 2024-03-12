package uteco4.prob12101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        backtrack(n, 0, new StringBuilder());
        String ans;
        try {
            ans = anss.get(k - 1);
        } catch (Exception e) {
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ans.length(); i++) {
            sb.append(ans.charAt(i)).append("+");
        }
        System.out.println(sb.substring(0, sb.lastIndexOf("+")));
    }

    static List<String> anss = new ArrayList<>();

    static void backtrack(int n, int c, StringBuilder sb) {
        if (n == c) {
            anss.add(sb.toString());
            return;
        }
        if (c > n) {
            return;
        }
        for (int i = 1; i <= 3; i++) {
            backtrack(n, c + i, new StringBuilder().append(sb).append(i));
        }
    }
}
