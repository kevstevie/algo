package uteco6.prob17503;

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

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Beer> l = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            l.add(new Beer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        long left = 0;
        long right = Integer.MAX_VALUE;

        long ans = -1;

        l.sort(Comparator.comparing((Beer beer) -> beer.prefer).reversed());
        while (left <= right) {
            long mid = (left + right) / 2;

            long sum = 0;
            int cnt = 0;
            for (Beer beer : l) {
                if (cnt == n) break;
                if (beer.level > mid) {
                    continue;
                }
                cnt++;
                sum += beer.prefer;
            }

            if (sum >= m && cnt == n) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(ans);
    }

    static class Beer {

        int prefer;
        int level;

        public Beer(int prefer, int level) {
            this.prefer = prefer;
            this.level = level;
        }
    }
}
