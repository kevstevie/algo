package prob2606;

import org.w3c.dom.ls.LSException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        List<List<Integer>> l = new ArrayList<>();

        for (int i = 0; i < n + 2; i++) {
            l.add(new ArrayList<>());
        }

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            l.get(s).add(e);
            l.get(e).add(s);
        }

        boolean[] visit = new boolean[n + 1];

        Stack<Integer> s = new Stack<>();

        s.push(1);
        visit[1] = true;

        int ans = 0;

        while (!s.isEmpty()) {
            Integer now = s.pop();

            List<Integer> ints = l.get(now);
            for (Integer i : ints) {
                if (visit[i]) continue;
                s.push(i);
                ans++;
                visit[i] = true;
            }
        }

        System.out.println(ans);
    }
}
