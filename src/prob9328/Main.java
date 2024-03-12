package prob9328;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int[][] m = new int[x][y];
            boolean[][][] v = new boolean[x][y][(1 << 26) - 1];
            for (int j = 0; j < x; j++) {
                String s = br.readLine();
                for (int k = 0; k < y; k++) {
                    char c = s.charAt(y);
                    if(c == '*') {
                        m[j][k] = -1;
                    } else if (c == '.') {
                        m[j][k] = -2;
                    } else if (c >= 'a' && c <= 'z') {
                        m[j][k] = c - 'a';
                    }else if (c >= 'A' && c <= 'Z') {
                        m[j][k] = c - 'A' + 26;
                    }
                }
            }
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {

            }
        }
    }
}
