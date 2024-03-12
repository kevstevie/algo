package prob2230;

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

        List<Integer> l = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            l.add(Integer.parseInt(br.readLine()));
        }

        l.sort(Comparator.naturalOrder());

        int a = 0;
        int b = 0;
        int min = Integer.MAX_VALUE;
        while (b < l.size()) {
            int aa = l.get(a);
            int bb = l.get(b);
            if (bb - aa < m) {
                b++;
            } else {
                if (bb - aa <= min) {
                    min = bb - aa;
                }
                if (++a >= l.size()) {
                    break;
                }
            }
        }

        System.out.println(min);
    }

}
