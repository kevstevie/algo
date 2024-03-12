package prob1912;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = Integer.MIN_VALUE;
        int temp = 0;

        for (int i = 0; i < n; i++) {
            if (temp < 0) {
                temp = 0;
            }
            temp += arr[i];
            ans = Math.max(ans, temp);
        }

        System.out.println(ans);
    }
}
