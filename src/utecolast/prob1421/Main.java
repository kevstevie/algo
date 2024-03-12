package utecolast.prob1421;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        long max = 0;
        long maxt = 0;

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            maxt = Math.max(k, maxt);
            arr[i] = k;
        }

        for (int i = 1; i <= maxt; i++) {
            long val = 0;
            for (int j = 0; j < n; j++) {
                long cutc = 0;
                long tsum = 0;
                if (arr[j] < i) continue;
                if (arr[j] == i) {
                    val += w * i;
                    continue;
                }
                if (arr[j] % i == 0) {
                    tsum += arr[j] / i;
                    cutc += arr[j] / i - 1;
                } else {
                    tsum += arr[j] / i;
                    cutc += arr[j] / i;
                }
                val += Math.max(0, tsum * w * i - c * cutc);
            }
            max = Math.max(val, max);
        }

        System.out.println(max);
    }
}
