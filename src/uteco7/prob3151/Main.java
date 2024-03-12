package uteco7.prob3151;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {


    static long ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> l = new ArrayList<>();

        int[] arr = new int[20001];
        for (int i = 0; i < n; i++) {
            int e = Integer.parseInt(st.nextToken());
            l.add(e);
            arr[e + 10000]++;
        }

        l.sort(Comparator.naturalOrder());

        int[] t = new int[20001];
        for (int i = 0; i < n; i++) {
            System.arraycopy(arr, 0, t, 0, 20001);
            for (int j = 0; j <= i; j++) {
                t[l.get(j) + 10000]--;
            }
            for (int k = i + 1; k < n; k++) {
                int sum = l.get(i) + l.get(k);
                if (sum * -1 + 10000 >= 20001) continue;
                if (sum * -1 + 10000 < 0) continue;
                t[l.get(k) + 10000]--;
                ans += t[sum * -1 + 10000];
            }
        }


        System.out.println(ans);
    }

}

/*
10
2 -5 2 3 -4 7 -4 0 1 -6
-6 -5 -4 -4 0 1 2 2 3 7

6

5
-4 2 2 2 2

6

5
-1 -1 -1 -1 2

6

4
-1 0 0 1

1 -> 2

10
0 0 0 0 0 0 0 0 0 0

120
 */
