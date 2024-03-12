package prob2467;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Long> l = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            l.add(Long.parseLong(st.nextToken()));
        }
        l.sort(Comparator.naturalOrder());

        int c = 0;
        int d = n - 1;

        long ans1 = l.get(c);
        long ans2 = l.get(d);
        long prev = Math.abs(l.get(c) + l.get(d));

        while (c < d) {
            Long a = l.get(c);
            Long b = l.get(d);
            long sum = a + b;
            long abs = Math.abs(a + b);

            if (abs <= prev) {
                ans1 = a;
                ans2 = b;
                prev = abs;
            }
            if (sum >= 0) {
                d--;
            } else {
                c++;
            }

        }
        System.out.println(ans1 + " " + ans2);
    }

}
