package prob15663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        List<Integer> l = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            l.add(Integer.parseInt(st.nextToken()));
        }

        List<String> ll = l.stream()
                           .sorted(Comparator.naturalOrder())
                           .map(String::valueOf)
                           .collect(Collectors.toList());

        recur(0, new String[m], ll, new boolean[ll.size()]);
        for (String s : ans) {
            sb.append(s).append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    static Set<String> ans = new LinkedHashSet<>();

    static void recur(int c, String[] s, List<String> ll, boolean[] visit) {
        if (c == m) {
            String ss = String.join(" ", s);
            ans.add(ss);
            return;
        }

        for (int i = 0; i < ll.size(); i++) {
            if (visit[i]) continue;
            s[c] = ll.get(i);
            visit[i] = true;
            recur(c + 1, s, ll, visit);
            visit[i] = false;
        }
    }

}
