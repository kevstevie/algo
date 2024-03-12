package prob27172;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] p = new int[1000001];
        int max = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            p[num] = i;
            max = Math.max(max, num);
        }

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int num = arr[i];
            for (int j = 2; num * j <= max; j++) {
                if (p[j * num] != 0) {
                    ans[p[num]]++;
                    ans[p[j * num]]--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int an : ans) {
            sb.append(an).append(" ");
        }
        System.out.println(sb);
    }
}
