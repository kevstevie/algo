package uteco5.prob14469;

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

        List<Cow> cows = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int ar = Integer.parseInt(st.nextToken());
            int wait = Integer.parseInt(st.nextToken());

            cows.add(new Cow(ar, wait));
        }

        cows.sort(Comparator.comparing(cow -> cow.ar));

        int time = 0;

        for (int i = 0; i < n; i++) {
            Cow cow = cows.get(i);
            time = Math.max(time, cow.ar);
            time += cow.wait;
        }

        System.out.println(time);
    }

    static class Cow {
        int ar;
        int wait;

        public Cow(int ar, int wait) {
            this.ar = ar;
            this.wait = wait;
        }
    }
}
