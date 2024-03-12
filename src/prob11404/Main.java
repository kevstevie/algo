package prob11404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        long[][] map = new long[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(map[i], Integer.MAX_VALUE);
            map[i][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            map[start][end] = Math.min(map[start][end], dist);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
//                    if (map[j + 1][k + 1] == 0) continue;
                    map[j + 1][k + 1] = Math.min(map[j + 1][k + 1], map[j + 1][i + 1] + map[i + 1][k + 1]);
                }
            }
        }
//        2147483647 0 2 3 2 5
//        2147483647 12 0 15 2 5
//        2147483647 8 9 0 2 5
//        2147483647 10 7 13 0 3
//        2147483647 7 4 10 6 0

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String collect = Arrays.stream(map[i + 1])
                    .skip(1L)
                    .map(it -> {if (it >= Integer.MAX_VALUE) {
                    return 0;}
                        else return it;
                    })
                                   .mapToObj(String::valueOf)
                                   .collect(Collectors.joining(" "));
            sb.append(collect).append(System.lineSeparator());
        }

        System.out.println(sb);
    }

}
