package prob15654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(Integer.parseInt(st.nextToken()));
        }

        List<String> l = a.stream()
                          .sorted()
                          .map(String::valueOf)
                          .collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        recur(0, 0, n, m, l, new String[m], sb, new boolean[n]);

        System.out.println(sb);
    }

    static void recur(int c, int idx, int n, int m, List<String> l, String[] s, StringBuilder sb, boolean[] visit) {
        if (c == m) {
            sb.append(String.join(" ", s)).append(System.lineSeparator());
            return;
        }
        if (idx >= l.size()) {
            return;
        }
//        recur(c, idx + 1, n, m, l, s, sb);
        for (int i = 0; i < n; i++) {
            if (visit[i]) continue;
            s[c] = l.get(i);
            visit[i] = true;
            recur(c + 1, idx + 1, n, m, l, s, sb, visit);
            visit[i] = false;
        }
    }
}
