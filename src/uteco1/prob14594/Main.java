package uteco1.prob14594;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        boolean[] arr = new boolean[n];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for (int j = x; j < y; j++) {
                arr[j] = true;
            }
        }

        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i]) {
                cnt++;
            }
        }

        System.out.println(cnt);

    }

}
