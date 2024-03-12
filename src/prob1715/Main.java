package prob1715;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Long> q = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            q.offer(Long.parseLong(br.readLine()));
        }

        long ans = 0;
        while (!q.isEmpty()) {
            Long poll = q.poll();
            if (q.isEmpty()) {
                System.out.println(ans);
                return;
            }
            Long poll1 = q.poll();
            q.offer(poll + poll1);
            ans += poll + poll1;
        }
    }

}
