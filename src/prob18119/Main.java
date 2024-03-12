package prob18119;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        int[] bits = new int[n];

        for (int i = 0; i < n; i++) {
            String word = words[i];
            int b = 0;
            for (int j = 0; j < word.length(); j++) {
                int i1 = word.charAt(j) - 'a';
                b |= 1 << i1;
            }
            bits[i] = b;
        }

        int bit = (1 << 26) - 1;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int o = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);

            if (o == 1) {
                bit &= ~(1 << (c - 'a'));
            } else {
                bit |= 1 << (c - 'a');
            }
            int ans = 0;
            for (int b : bits) {
//                boolean flag = true;
//                for (int j = 0; j < 26; j++) {
//                    if (((bit & (1 << j)) != (1 << j)) && (((b & (1 << j)) == (1 << j)))) {
//                        flag = false;
//                        break;
//                    }
//                }
//                if (flag) {
//                    ans++;
//                }
                if ((bit & b) >= b) {
                    ans++;
                }
            }
            sb.append(ans).append(System.lineSeparator());
        }

        System.out.println(sb);
    }
}
