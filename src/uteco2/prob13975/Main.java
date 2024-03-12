package uteco2.prob13975;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            PriorityQueue<Long> q = new PriorityQueue<>();

            for (int j = 0; j < n; j++) {
                long k = Long.parseLong(st.nextToken());
                q.offer(k);
            }

            long result = 0;

            while (q.size() > 2) {
                Long one = q.poll();
                Long two = q.poll();
                long three = one + two;
                result += three;
                q.offer(three);
            }
            result += q.poll();
            result += q.poll();

            sb.append(result).append(System.lineSeparator());
        }

        System.out.println(sb);
    }

}

/*
2
4
40 30 30 50
15
1 21 3 4 5 35 5 4 3 5 98 21 14 17 32

60
90
150

40 50 60
90 60
 */
