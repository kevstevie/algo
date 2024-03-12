package prob16437;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<List<Integer>> l = new ArrayList<>();
        arr = new long[n + 1];
        parents = new int[n + 1];
        arr[1] = 0;

        for (int i = 0; i <= n; i++) {
            l.add(new ArrayList<>());
        }

        for (int i = 2; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String kind = st.nextToken();
            int count = Integer.parseInt(st.nextToken());
            int parent = Integer.parseInt(st.nextToken());

            if (kind.equals("S")) {
                arr[i] = count;
            } else {
                arr[i] = -count;
            }
            l.get(parent).add(i);
            parents[i] = parent;
        }

        postOrder(1, l);

        ans = arr[1];


        System.out.println(ans);
    }

    static int[] parents;
    static long[] arr;
    static long ans;

    static void postOrder(int now, List<List<Integer>> nodes) {
        List<Integer> l = nodes.get(now);

        for (Integer next : l) {
            postOrder(next, nodes);
        }
        calculate(now);
    }

    private static void calculate(int now) {
        if (now == 1) {
            return;
        }
        arr[parents[now]] = Math.max(arr[parents[now]], arr[parents[now]] + arr[now]);

    }
}

/*
7
W 100 1
S 100 1
S 100 1
S 50 2
W 100 2
S 10000 6

10050

5
S 100 1
S 100 2
S 100 3
S 100 1

400

5
W 200 1
S 100 2
S 200 3
S 200 4

300

6
W 100 1
S 100 1
S 200 1
S 100 1
W 150 1

400

4
W 1000 1
S 200 2
S 200 3
S 200 3

0
 */
