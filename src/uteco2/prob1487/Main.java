package uteco2.prob1487;

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
        List<Buyer> l = new ArrayList<>();

        int ms = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            ms += s;
            l.add(new Buyer(p, s));
        }

        l.sort(Comparator.comparing((Buyer b) -> b.price).thenComparing((Buyer b) -> b.shipping));

        int ans = 0;
        int max = 0;
        int calc = 0;
        for (int i = 0; i < n; i++) {
            int now = l.get(i).price;
            calc = 0;
            for (int j = i; j < n; j++) {
                calc += Math.max(now - l.get(j).shipping, 0);
            }
            if (calc > max) {
                ans = l.get(i).price;
                max = calc;
            }
        }

        System.out.println(ans);
    }

    static class Buyer {

        int price;
        int shipping;

        public Buyer(int price, int shipping) {
            this.price = price;
            this.shipping = shipping;
        }
    }

}
