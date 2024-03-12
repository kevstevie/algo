package prob2110;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for (int i = 0; i < C; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int[] a = new int[N - 1];

        for (int i = 0; i < N - 1; i++) {
            a[i] = arr[i + 1] - arr[i];
        }

        int left = 2;
        int right = 200_000;

        int ans = 0;

        while (left < right) {
            int mid = (left + right) / 2;

            

        }


        System.out.println(ans);
    }
}
