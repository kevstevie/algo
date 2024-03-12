package prob17244;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int seq = -1;
        int[][] start = new int[1][2];

        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                char c = s.charAt(j);
                if (c == '#') {
                    map[j][i] = 5;
                } else if (c == 'S') {
                    map[j][i] = 6;
                    start[0][0] = i;
                    start[0][1] = j;
                } else if (c == 'X') {
                    map[j][i] = ++seq;
                } else if (c == 'E') {
                    map[j][i] = 7;
                } else {
                    map[j][i] = 6;
                }
            }
        }
        boolean[][][] visit = new boolean[n][m][(1 << seq + 1)];

        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(start[0][0], start[0][1], 0, 0));
//        visit[start[0][1]][start[0][0]][0] = true;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int i = 0; i < 4; i++) {
                int xx = now.x + dx[i];
                int yy = now.y + dy[i];

                if (xx < 0 || yy < 0 || xx >= m || yy >= n) {
                    continue;
                }
                if (visit[yy][xx][now.bit]) {
                    continue;
                }
                if (map[yy][xx] == 5) {
                    continue;
                }

                if (map[yy][xx] == 7) {
                    if (now.bit == (1 << seq + 1) - 1) {
                        System.out.println(now.dis + 1);
                        return;
                    }
                }
                if (map[yy][xx] >= 0 && map[yy][xx] <= 4 && (now.bit & (1 << map[yy][xx])) == 0) {
                    q.offer(new Node(xx, yy, now.dis + 1, now.bit | 1 << map[yy][xx]));
                    visit[yy][xx][now.bit] = true;
                    continue;
                }
                q.offer(new Node(xx, yy, now.dis + 1, now.bit));
                visit[yy][xx][now.bit] = true;
            }
        }
    }
    static class Node {
        int x;
        int y;
        int dis;
        int bit;

        public Node(int x, int y, int dis, int bit) {
            this.x = x;
            this.y = y;
            this.dis = dis;
            this.bit = bit;
        }
    }
}
/*
4 4
####
#SXE
#XX#
####

4 4
####
#XXE
#XS#
####

3 3
###
#SE
###

5 3
#####
#S..E
#####

3 7
###
#X#
#.#
#S#
#.#
#X#
#E#

8 3
########
#X.S.X.E
########
 */
