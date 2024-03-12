package uteco1.prob26215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.comparingInt(o -> (int) o).reversed());

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(st.nextToken());
            q.offer(k);
        }

        while (q.size() != 1) {
            int poll = q.poll();
            if (poll == 0) continue;

            if (!q.isEmpty()) {
                Integer smaller = q.poll();
                poll -= smaller;
                ans += smaller;
                q.offer(poll);
            }
        }

        ans += q.poll();
        System.out.println(ans > 1440 ? -1 : ans);
    }
}
