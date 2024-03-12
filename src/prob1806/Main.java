package prob1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            arr[i] += arr[i - 1] + Integer.parseInt(st.nextToken());
        }

        int c = 1;
        int d = 1;

        int ans = Integer.MAX_VALUE;

        while (d < arr.length) {
            int sum = arr[d] - arr[c - 1];
            if (sum < s) {
                d++;
            } else {
                ans = Math.min(d - c + 1, ans);
                c++;
            }
        }

        System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
    }

}
