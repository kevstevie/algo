package prob2470;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] ar = new int[n];

        for (int i = 0; i < n; i++) {
            ar[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ar);

        int left = 0;
        int right = n - 1;

        int ans = ar[left] + ar[right];
        int ansl = ar[left];
        int ansr = ar[right];

        while (left < right) {
            int temp = ar[left] + ar[right];
            if (Math.abs(ans) > Math.abs(temp)) {
                ansl = ar[left];
                ansr = ar[right];
                ans = temp;
            }
            if (temp > 0) {
                right--;
            } else {
                left++;
            }
        }
        System.out.println(ansl + " " + ansr);
    }
}

/*
-99 -2 -1 4 98

6
-100 -99 -98 -97 -96 -95

5
-100 -99 -98 0 100 200
 */
