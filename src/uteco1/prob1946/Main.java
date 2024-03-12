package uteco1.prob1946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            List<int[]> l = new ArrayList<>();
            int[][] arr = new int[n][2];
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                l.add(new int[]{a, b});
            }
            int ans = 1;
            int idx = 0;
            l.sort(Comparator.comparing(it -> it[0]));
            for (int j = 0; j < n - 1; j++) {
                if (l.get(idx)[1] > l.get(j + 1)[1]) {
                    ans++;
                    idx = j + 1;
                    if (idx > l.size()) {
                        break;
                    }
                }
            }
            sb.append(ans).append(System.lineSeparator());
        }

        System.out.println(sb);
    }
}
/*
3 6
7 3
4 2
1 4
5 7
2 5
6 1

1 4
2 5
3 6
4 2
5 7
6 1
7 3

6 1
4 2
7 3
1 4
2 5
3 6
5 7

1 4
2 3
3 2
4 1
5 5
 */
