package uteco.prob9017;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            List<List<Integer>> l = new ArrayList<>();
            for (int j = 0; j <= 201; j++) {
                l.add(new ArrayList<>());
            }
            int[] cnt = new int[201];
            for (int j = 1; j <= n; j++) {
                int team = Integer.parseInt(st.nextToken());
                cnt[team]++;
            }
            int[] scores = new int[201];

            int k = 1;
                StringTokenizer stringTokenizer = new StringTokenizer(str);
            for (int j = 0; j < n; j++) {
                int q = Integer.parseInt(stringTokenizer.nextToken());
                if (cnt[q] < 6) {
                    continue;
                }
                l.get(q).add(k++);
            }

            for (int j = 0; j < l.size(); j++) {
                List<Integer> integers = l.get(j);
                if (integers.size() < 6) continue;
                int sum = integers.stream().mapToInt(it -> it).sorted().limit(4).sum();
                scores[j] = sum;
            }

            int winner = 0;
            int min = Integer.MAX_VALUE;
            for (int j = 1; j < 201; j++) {
                if (scores[j] == 0) continue;
                if (scores[j] < min) {
                    winner = j;
                    min = scores[j];
                } else if(scores[j] == min) {
                    Integer f1 = l.get(winner).get(4);
                    Integer f2 = l.get(j).get(4);

                    if (f1 > f2) {
                        winner = j;
                    }
                }
            }
            sb.append(winner).append(System.lineSeparator());
        }

        System.out.println(sb);
    }
}
