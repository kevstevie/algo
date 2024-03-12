package utecolast.prob2578;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, Coordinate> m = new HashMap<>();
        boolean[][] v = new boolean[5][5];

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                m.put(Integer.parseInt(st.nextToken()), new Coordinate(i, j));
            }
        }

        int cnt = 0;

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                Coordinate coordinate = m.get(num);
                v[coordinate.x][coordinate.y] = true;
                cnt++;

                if (checkBingo(v)) {
                    System.out.println(cnt);
                    return;
                }
            }
        }
    }

    private static boolean checkBingo(boolean[][] v) {
        int bingocnt = 0;
        for (int i = 0; i < 5; i++) {
            int cnt = 0;
            for (int j = 0; j < 5; j++) {
                if (v[i][j]) cnt++;
            }
            if (cnt == 5) {
                bingocnt++;
            }
        }

        for (int i = 0; i < 5; i++) {
            int cnt = 0;
            for (int j = 0; j < 5; j++) {
                if(v[j][i]) cnt++;
            }
            if (cnt == 5) {
                bingocnt++;
            }
        }

            int cnt = 0;
        for (int i = 0; i < 5; i++) {
            if(v[i][i]) cnt++;
            if (cnt == 5) {
                bingocnt++;
            }
        }
             cnt = 0;
        for (int i = 0; i < 5; i++) {
            if (v[i][4 - i]) {
                cnt++;
            }
            if (cnt == 5) {
                bingocnt++;
            }
        }

        return bingocnt >= 3;
    }

    static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
