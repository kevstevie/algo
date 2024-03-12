package prob2473;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] arr = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            long j = Long.parseLong(st.nextToken());
            arr[i] = j;
        }

        Arrays.sort(arr);

        long min = Long.MAX_VALUE;
        long[] ans = new long[3];

        for (int i = 0; i < n; i++) {
            int mid = i + 1;
            int right = n - 1;

            while (right > mid) {
                long temp = arr[i] + arr[mid] + arr[right];
                if (Math.abs(min) > Math.abs(temp)) {
                    ans[0] = arr[i];
                    ans[1] = arr[mid];
                    ans[2] = arr[right];
                    min = Math.abs(temp);
                }
                if (temp > 0) {
                    right--;
                } else {
                    mid++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (long an : ans) {
            sb.append(an).append(" ");
        }

        System.out.println(sb);
    }
}

/*
5
-999999999 -1000000000 -1000000000 -1000000000 -1000000000

5
999999999 1000000000 1000000000 1000000000 1000000000
 */
