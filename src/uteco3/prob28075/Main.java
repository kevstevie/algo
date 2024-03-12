package uteco3.prob28075;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[] info;
    static int[] view;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        info = new int[3];
        view = new int[3];

        st = new StringTokenizer(br.readLine());
        info[0] = Integer.parseInt(st.nextToken());
        info[1] = Integer.parseInt(st.nextToken());
        info[2] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        view[0] = Integer.parseInt(st.nextToken());
        view[1] = Integer.parseInt(st.nextToken());
        view[2] = Integer.parseInt(st.nextToken());


        recur(0, 4, 0);

        System.out.println(ans);
    }

    static void recur(int cnt, int prev, int val) {
        if (cnt == n) {
            if (val >= m) {
                ans++;
            }
            return;
        }
        for (int i = 0; i < 3; i++) {
            recur(cnt + 1, i, (i == prev ? info[i] / 2 : info[i]) + val);
            recur(cnt + 1, i, (i == prev ? view[i] / 2 : view[i]) + val);
        }
    }

}
