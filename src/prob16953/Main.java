package prob16953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        int cnt = 0;
        while (b > a) {
            if (b % 2 == 0) {
                b = b / 2;
                cnt++;
            } else if ((b - 1) % 10 == 0) {
                b = (b - 1) / 10;
                cnt++;
            } else {
                System.out.println(-1);
                return;
            }
            if (b == a) {
                System.out.println(cnt + 1);
                return;
            }
        }
        System.out.println(-1);
    }

}
