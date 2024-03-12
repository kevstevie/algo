package prob2096;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][3];
        int[][] arr2 = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[i][0] = a;
            arr[i][1] = b;
            arr[i][2] = c;
            arr2[i][0] = a;
            arr2[i][1] = b;
            arr2[i][2] = c;
        }

        int max = 0;
        int min = Integer.MAX_VALUE;
        
        for (int i = 1; i < n; i++) {
            arr[i][0] += Math.max(arr[i - 1][0], arr[i - 1][1]);
            arr[i][1] += Math.max(arr[i - 1][0], Math.max(arr[i - 1][1], arr[i - 1][2]));
            arr[i][2] += Math.max(arr[i - 1][1], arr[i - 1][2]);
        }
        for (int i : arr[n - 1]) {
            max = Math.max(i, max);
        }

        for (int i = 1; i < n; i++) {
            arr2[i][0] += Math.min(arr2[i - 1][0], arr2[i - 1][1]);
            arr2[i][1] += Math.min(arr2[i - 1][0], Math.min(arr2[i - 1][1], arr2[i - 1][2]));
            arr2[i][2] += Math.min(arr2[i - 1][1], arr2[i - 1][2]);
        }
        for (int i : arr2[n - 1]) {
            min = Math.min(i, min);
        }

        System.out.println(max + " " + min);
    }

}
