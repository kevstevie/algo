package utecolast.prob10813;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            arr[i] = i ;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            int temp = arr[f];

            arr[f] = arr[s];
            arr[s] = temp;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < n + 1; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);

    }
}
