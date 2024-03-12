package prob2252;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] s = sc.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int[] dp = new int[n + 1];
        List<List<Integer>> l = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            l.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] ss = sc.nextLine().split(" ");
            l.get(Integer.parseInt(ss[0])).add(Integer.parseInt(ss[1]));
            dp[Integer.parseInt(ss[1])]++;
        }

        StringBuilder ans = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (dp[i] == 0) {
                q.offer(i);
                ans.append(i).append(" ");
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < l.get(now).size(); i++) {
                int next = l.get(now).get(i);
                dp[next]--;
                if (dp[next] == 0) {
                    q.offer(next);
                    ans.append(next).append(" ");
                }
            }
        }
        System.out.println(ans);
    }
}
