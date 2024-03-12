package prob11723;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int bit = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if (s.equals("all")) {
                bit = (1 << 21) - 1;
                continue;
            }
            if (s.equals("empty")) {
                bit = 0;
                continue;
            }
            int num = Integer.parseInt(st.nextToken());
            if (s.equals("add")) {
                bit = bit | (1 << num);
            }
            if (s.equals("check")) {
                sb.append((bit & (1 << num)) == 0 ? 0 : 1).append(System.lineSeparator());
            }
            if (s.equals("remove")) {
                bit = bit & ~(1 << num);
            }

            if (s.equals("toggle")) {
                bit = bit ^ (1 << num);
            }
        }

        System.out.println(sb);
    }
}

/*
21
all
check 1
check 2
check 3
check 4
check 5
check 6
check 7
check 8
check 9
check 10
check 11
check 12
check 13
check 14
check 15
check 16
check 17
check 18
check 19
check 20
 */
