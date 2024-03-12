package uteco4.prob21967;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int ans = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int lc = 0;
        int rc = 0;
        int[] cnt = new int[11];
        cnt[arr[0]]++;
        while (rc < n) {
            int r = arr[rc];
            int l = arr[lc];
            int max = getMax(cnt);
            int min = getMin(cnt);
            if (max - min <= 2) {
                ans = Math.max(ans, rc - lc + 1);
                rc++;
                if (rc < n) {
                    cnt[arr[rc]]++;
                }
            } else {
                cnt[l]--;
                lc++;
            }

        }
        System.out.println(ans);
    }

    static int getMax(int[] arr) {
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != 0) {
                max = Math.max(i, max);
            }
        }
        return max;
    }

    static int getMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != 0) {
                min = Math.min(i, min);
            }
        }
        return min;
    }
}
/*
7
7 4 2 2 1 3 6

6
1 5 4 2 2 7

9
1 1 1 3 4 3 1 1 1

as is 6
to be 4

8
1 2 3 4 2 2 2 7

3
1 4 1

as is 2
to be 1
 */
