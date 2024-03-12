package prob11279;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.comparing((Integer a) -> Math.abs(a)).thenComparing(a -> a));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int j = Integer.parseInt(br.readLine());
            if (j == 0) {
                sb.append(q.isEmpty() ? 0 : q.poll()).append(System.lineSeparator());
            } else {
                q.offer(j);
            }

        }
        System.out.println(sb);
    }
}
