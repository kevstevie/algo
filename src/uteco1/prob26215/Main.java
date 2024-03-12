package uteco1.prob26215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> q = new PriorityQueue<>();

        int[] arr = new int[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(st.nextToken());
            arr[i] = k;
        }
        if (arr.length == 1) {
            System.out.println(arr[0] > 1440 ? -1 : arr[0]);
            return;
        }
        Arrays.sort(arr);

        while (arr[n - 1] != 0) {
            arr[n - 1] -= arr[n - 2];
            ans += arr[n - 2];
            if ( arr[ n - 2] == 0) {
                break;
            }
            arr[n - 2] = 0;
            Arrays.sort(arr);
        }
        ans += arr[n - 1];



        System.out.println(ans > 1440 ? -1 : ans);
    }
}
