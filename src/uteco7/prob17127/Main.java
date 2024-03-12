package uteco7.prob17127;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int ans = 0;
    static int n;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        permutation(0, 0, 0, new int[4]);

        System.out.println(ans);

    }

    static void permutation(int cnt, int sum, int idx, int[] p) {
        if (cnt == 4 && sum == n) {
            ans = Math.max(ans, calc(p, arr));
            return;
        }
        if (sum > n || idx >= 4) {
            return;
        }
        for (int i = 1; i <= 7; i++) {
            int[] ints = {p[0], p[1], p[2], p[3]};
            ints[idx] = i;
            permutation(cnt + 1, sum + i, idx + 1, ints);
        }
    }

    static int calc(int[] p, int[] arr) {
        int sum = 0;
        int temp = 1;
        for (int i = 0; i < p[0]; i++) {
            temp *= arr[i];
        }
        sum += temp;
        temp = 1;
        for (int i = p[0]; i < p[0] + p[1]; i++) {
            temp *= arr[i];
        }
        sum += temp;
        temp = 1;
        for (int i = p[0] + p[1]; i < p[0] + p[1] + p[2]; i++) {
            temp *= arr[i];
        }
        sum += temp;
        temp = 1;
        for (int i = p[0] + p[1] + p[2]; i < p[0] + p[1] + p[2] + p[3]; i++) {
            temp *= arr[i];
        }
        sum += temp;

        return sum;
    }
}
