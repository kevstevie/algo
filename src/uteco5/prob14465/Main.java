package uteco5.prob14465;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        boolean[] arr = new boolean[n + 1];

        for (int i = 0; i < b; i++) {
            int j = Integer.parseInt(br.readLine());
            arr[j] = true;
        }

        int cnt = 0;
        for (int i = 1; i <= k; i++) {
            if (arr[i]) {
                cnt++;
            }
        }

        int ans = cnt;
        int min = ans;

        for (int i = 1; i <= n - k; i++) {
            if (arr[i]) {
                ans--;
            }
            if (arr[i + k]) {
                ans++;
            }
            min = Math.min(ans, min);
        }

        System.out.println(min);

    }

}
