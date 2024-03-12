package uteco3.prob24041;

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

        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long G = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        List<Ing> l = new ArrayList<>();
        List<Ing> remove = new ArrayList<>();

        for (long i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            long s = Long.parseLong(st.nextToken());
            long o = Long.parseLong(st.nextToken());
            long r = Long.parseLong(st.nextToken());

            if (r == 1) {
                remove.add(new Ing(s, o));
                continue;
            }
            l.add(new Ing(s, o));
        }
        K = Math.min(remove.size(), K);

        long left = 0;
        long right = Integer.MAX_VALUE;
        long ans = 0;

        while (left <= right) {
            long mid = (left + right) / 2;

            long sum = l.stream().mapToLong(ing -> ing.calculate(mid)).sum();

            long sum1 = remove.stream().map(ing -> ing.calculate(mid))
                             .sorted(Comparator.reverseOrder())
                             .skip(K)
                             .mapToLong(a -> a)
                             .sum();

            sum += sum1;

            if (sum > G) {
                right = mid - 1;
            } else {
                ans = Math.max(ans, mid);
                left = mid + 1;
            }
        }

        System.out.println(ans);
    }

    static class Ing {
        long s;
        long l;

        public Ing(long s, long l) {
            this.s = s;
            this.l = l;
        }

        public long calculate(long day) {
            return s * Math.max(1, day - l);
        }
    }

}

/*
4 36 3
2 14 1
3 8 1
5 12 1
7 10 1

2 + 18 + 10
28
 */
